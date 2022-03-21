package com.perrytech.deposits.fitnesseFixtures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.perrytech.deposits.DepositRequest;

import fit.ColumnFixture;

public class ForFurtherCreditFixture {
    String userAccount;
    double accountBalance;
    String ffcAccount;
    double depositAmt;
    String depositDate;
    String currentDate;

    DepositRequest req;

    public void setUp() {
        
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserAccountBalance(double userAccountBalance) {
        this.accountBalance = userAccountBalance;
    }

    public void setFFCAccount(String ffcAccount) {
        this.ffcAccount = ffcAccount;
    }

    public void setDepositAmt(double depositAmt) {
        this.depositAmt = depositAmt;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String cleared() {
        if(req.isCleared() == true){
            return "Yes";
        }
        else {
            return "No";
        }
    }

    public double userAccountBalance() {
        return req.getAccountBalance();
    }

    public String userAccountNewLineItems() {
        String lineItems = "";
        for (String line : req.getAccountLineItems()) {
            lineItems = lineItems + line + "; ";
        }
        return lineItems.trim();
    }

    public String FFCAccount() {
        return req.getFfcAccount();
    }

    public String FFCAccountNewLineItems() {
        String lineItems = "";
        for (String line : req.getFFCaccountLineItems()) {
            lineItems = lineItems + line + "; ";
        }
        return lineItems.trim();
    }

    public void execute() {
        //call system operation
        req = new DepositRequest();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        req.setAccountBalance(accountBalance);
        req.setCurrentDate(LocalDate.parse(this.currentDate, formatter));
        req.setDepositAmt(depositAmt);
        req.setDepositDate(LocalDate.parse(this.depositDate, formatter));
        req.setFfcAccount(ffcAccount);
        req.setUserAccount(userAccount);
        req.postRequest();
    }
}