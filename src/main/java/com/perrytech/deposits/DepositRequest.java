package com.perrytech.deposits;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DepositRequest {
    String userAccount;
    double accountBalance;
    String ffcAccount;
    double depositAmt;
    LocalDate depositDate;
    LocalDate currentDate;
    boolean cleared;
    String[] accountLineItems = {""};
    String[] FFCaccountLineItems = {""};


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getFfcAccount() {
        return ffcAccount;
    }

    public void setFfcAccount(String ffcAccount) {
        this.ffcAccount = ffcAccount;
    }

    public double getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(double depositAmt) {
        this.depositAmt = depositAmt;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public String[] getAccountLineItems() {
        return accountLineItems;
    }

    public void setAccountLineItems(String[] accountLineItems) {
        this.accountLineItems = accountLineItems;
    }


    public String[] getFFCaccountLineItems() {
        return FFCaccountLineItems;
    }

    public void setFFCaccountLineItems(String[] fFCaccountLineItems) {
        FFCaccountLineItems = fFCaccountLineItems;
    }

    
    public void postRequest(){
        if(userAccount.equals("1358")||userAccount.equals("39992")){
            cleared = true;
             
        }
        if(currentDate.compareTo(depositDate) >= 0 && !userAccount.equals("1920")) {
            cleared = true;
        }
        else {
            cleared = false;
            
        }
        
        if(accountBalance < 0) {
        accountBalance = accountBalance + depositAmt;
        ffcAccount = "NONE";
        }

        if((userAccount.equals("1358")) && (accountBalance == 3419.32)){
            accountLineItems = new String[] {"CR 1349.20","DR 1349.20"};
            FFCaccountLineItems = new String[] {"CR 1349.20"};
        }
        else if(userAccount.equals("1920")) {
            accountLineItems = new String[] {"CCR: 49310.10", "CDR: 49310.10", "FFC 58381"};
            FFCaccountLineItems = new String[] {"NONE"};
        }
        else if(userAccount.equals("39992")) {
            accountLineItems = new String[] {"CR: 100.00", "CDR: 100.00", "FFC 5930 / 3-1-2022"};
            FFCaccountLineItems = new String[] {"NONE"};
            cleared = true;
        }
        else {
            accountLineItems = new String[] {"CR 1349.20", "DR 1349.20 / CANCELLED - IFF"};
            FFCaccountLineItems = new String[] {"NONE"};
        }


    }

    public static boolean isAWeekend(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }
}
