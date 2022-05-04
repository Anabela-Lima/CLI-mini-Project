package Extras;

public enum Month {

    // set of allowed values that the object we create in enunmMain can use
    // value has to start with a letter not number. To give order use numbers i.e. associate a value to it

    JANUARY (1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);



// property
    private final int monthNumber;

    Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }
// getters and setters
    public int getMonthNumber(){
        return this.monthNumber;
    }
}
