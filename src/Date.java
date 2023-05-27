public class Date {
    int day=1; // 1 - 31
    int month=1; //1 - 12
    int year=0; //-9999 - 9999
    boolean hasTime=false;

    public Date(int day, int month ,int year){
        if (day<=31 && day>=1){
            this.day=day;
        }
        if (month<=12 && month>=1){
            this.month=month;
        }
        if (year<=9999 && year>=-9999){
            this.year=year;
        }
    }
    public Date(){}

    @Override
    public String toString() {
        String dayString = String.format("%02d",day);
        String monthString = String.format("%02d",month);
        String yearString = String.format("%04d",year); // TODO: test -1234 is it 4 digits?
        return dayString+"/"+monthString+"/"+yearString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date && !hasTime){
            return this.hashCode() == obj.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() { //TODO: to many years
        return day + 31*month + 12*31*year;
    }
}

