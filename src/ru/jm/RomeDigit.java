package ru.jm;

public enum RomeDigit {
    I("1"),
    II("2"),
    III("3"),
    IV("4"),
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
    IX("9"),
    X("10"),
    XI("11"),
    XX("20"),
    XXX("30"),
    XL("40"),
    L("50"),
    LX("60"),
    LXX("70"),
    LXXX("80"),
    XC("90"),
    C("100");

    public static int contains(String a) {
        int result=-1;
        for (int i=0;i<RomeDigit.values().length;i++)
            if (RomeDigit.values()[i].getTitle().equals(a)) {
                result = i;
                break;
            }
        return result;
    }

    private String title;

    RomeDigit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    }
