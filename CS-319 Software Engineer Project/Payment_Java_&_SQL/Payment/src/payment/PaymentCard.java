package payment;

import java.sql.*;

public class PaymentCard 
{
    int Paymentid;
    String BankName;
    int CardNum;
    int CVCCode;
    int expirationDate;
    
    public PaymentCard( 
                        int Paymentid,
                        String BankName,
                        int CardNum,
                        int CVCCode,
                        int expirationDate
                      )
    {
        this.Paymentid = Paymentid;
        this.BankName = BankName;
        this.CardNum = CardNum;
        this.CVCCode = CVCCode;
        this.expirationDate = expirationDate;
    }
    
         public int getPaymentid()
    {
        return this.Paymentid;
    }
    public void setPaymentid(int Paymentid)
    {
        this.Paymentid = Paymentid;
    }
    
    public String getBankName()
    {
        return this.BankName;
    }
    public void setBankName(String BankName)
    {
        this.BankName = BankName;
    }
    
    public int getCardNum()
    {
        return this.CardNum;
    }
    public void setCardNum(int CardNum)
    {
        this.CardNum = CardNum;
    }
    
     public int getCVCCode()
    {
        return this.CVCCode;
    }
    public void setCVCCode(int CVCCode)
    {
        this.CVCCode = CVCCode;
    }
    
    public int getexpirationDate()
    {
        return this.expirationDate;
    }
    public void setexpirationDate(int expirationDate)
    {
        this.expirationDate = expirationDate;
    }   
}