package ru.jm;

public enum RegExString {
    ARABIC("\\d{1,2}\\s\\W{1}\\s\\d{1,2}"),
    ROME("[IVX]{1,4}\\s\\W{1}\\s[IVX]{1,4}");

    private String regEx;

    RegExString(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
