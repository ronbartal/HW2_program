public class DateTime extends Date {
    public int hour=0;
    public int minute=0;

    public DateTime(int day, int month ,int year, int hour, int minute){
        super(day,month,year);
        if (hour<=23 && hour>=0){
            this.hour=hour;
        }
        if (minute<=59 && hour>=0){
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
    public int hashCode() { //TODO: to many years
        return super.hashCode()*24*60+ hour*60 + minute;
    }

    }
