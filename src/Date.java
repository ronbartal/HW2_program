public class Date {
    int day=1; // 1 - 31
    int month=1; //1 - 12
    int year=0; //-9999 - 9999

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

    @Override
    public String toString() {
        String daySting = String.format("%02d",day);
        String monthSting = String.format("%02d",month);
        String yearSting = String.format("%04d",year); // TODO: test -1234 is it 4 digits?
        return "/"+daySting+"/"+monthSting+"/"+yearSting;
    }

}
