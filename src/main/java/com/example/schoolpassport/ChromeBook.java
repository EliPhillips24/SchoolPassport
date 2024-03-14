package com.example.schoolpassport;

import java.time.LocalDate;
import java.util.ArrayList;

public class ChromeBook  {

    static ArrayList<ChromeBook> allChromeBooks;
    private int cbid;
    private LocalDate checkedOutDate;
    private GoIn whoCheckedOut;

    public ChromeBook(int cbid, LocalDate checkedOutDate, GoIn whoCheckedOut) {
        this.cbid = cbid;
        this.checkedOutDate = checkedOutDate;
        this.whoCheckedOut = whoCheckedOut;
        if (allChromeBooks == null) {
            allChromeBooks = new ArrayList<ChromeBook>();
        }
        allChromeBooks.add(this);
    }

    public int getCbid() {
        return cbid;
    }

    public void setCbid(int cbid) {
        this.cbid = cbid;
    }

    public LocalDate getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDate checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public GoIn getWhoCheckedOut() {
        return whoCheckedOut;
    }

    public void setWhoCheckedOut(GoIn whoCheckedOut) {
        this.whoCheckedOut = whoCheckedOut;
    }
}