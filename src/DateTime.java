public class DateTime extends Date {
    protected int hour=0;
    protected int minute=0;

    public DateTime(int year, int month ,int day, int hour, int minute){
        super(year,month,day);
        if (hour<=23 && hour>=0){
            this.hour=hour;
        }
        if (minute<=59 && minute>=0){
            this.minute=minute;
        }
        this.hasTime=true;
    }
    @Override
    public String toString() {
        String dateString=super.toString();
        String hourString = String.format("%02d",hour);
        String minuteString = String.format("%02d",minute);

        return dateString + " "+ hourString + ":" + minuteString;
    }
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof DateTime)){
            return this.hashCode()== obj.hashCode();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return super.hashCode()*24*60 + hour*60 + minute;
    }

    public void setHour(int hour) {
        if (hour <= 23 && hour >= 0) {
            this.hour = hour;
        }
        else this.hour=0;
    }
    public void setMinute(int minute) {
        if (minute <= 59 && minute >= 0) {
            this.minute = minute;
        }
        else this.minute=0;
    }


    }
