/**
 * Date in the years -3999 to 3999
 */
public class Date {
    protected int day=1; // 1 - 31
    protected int month=1; //1 - 12
    protected int year=0; //-3999 - 3999
    protected boolean hasTime=false;

    public Date(int year, int month ,int day){
        if (day<=31 && day>=1){
            this.day=day;
        }
        if (month<=12 && month>=1){
            this.month=month;
        }
        if (year<=3999 && year>=-3999){
            this.year=year;
        }
    }
    public Date(){}

    /**
     * Orders the date values to the wanted template: "dd/mm/yyyy"
     * @return string that shows the date
     */
    @Override
    public String toString() {
        String dayString = String.format("%02d",day);
        String monthString = String.format("%02d",month);
        String yearString = String.format("%04d",year);
        return dayString+"/"+monthString+"/"+yearString;
    }

    /**
     * Checks if other object is identify to this
     * @param obj other object to compare
     * @return true if obj is date type and share the same values exactly
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date && !hasTime){
            return this.hashCode() == obj.hashCode();
        }
        return false;
    }

    /**
     * Returns a unique number as a function of the values
     * @return
     */
    @Override
    public int hashCode() { //TODO: to many years
        return day + 31*month + 12*31*year;
    }

    public void setDay(int day) {
        if (day <= 31 && day >= 1) {
            this.day = day;
        }
        else this.day=1;
    }
    public void setMonth(int month) {
        if (month <= 12 && month >= 1) {
            this.month = month;
        }
        else this.month=1;
    }
    public void setYear(int year) {
        if (year <= 9999 && year >= -9999) {
            this.year = year;
        }
        else this.year=0;
    }
}

