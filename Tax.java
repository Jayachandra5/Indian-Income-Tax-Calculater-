import java.util.*;

/** 
 * 
 * @author Jayachandra
 * @since July 2022
 * @version tax.1.o
 * 
 * Income Tax Calulator.
 */

public class Tax {
    
 static float pr1,sto,stt,lt20t,lt10t;
 static float st,lt20,lt10;
 static float Total_Income,tcgain;
 
// Calucate Tax by new Tax Regime.
    
     static double New(float t)
    {
      double a,b,c;
      if(t<=500000)
          a=0;
      else if(t>500000 && t<=750000)
          a=12500+(t-500000)*0.1;
      else  if(t>750000 && t<=1000000)
          a=37500+(t-750000)*0.15;
      else  if(t>1000000 && t<=1250000)
          a=75000+(t-1000000)*0.20;
      else if(t>1250000 && t<=1500000)
          a=125000+(t-1250000)*0.25;
      else 
          a=187500+(t-1500000)*0.30;
      
      b=a+tcgain;
      c=b+b*0.04;  // Education cess @ 4%
      return c;
    }
     
 //program that collects data of 80C,80TTA(interst on saveing account ) and  80D (Health Insurance Premium).   
     static double old(float t)
     {
         Scanner bc= new Scanner(System.in);
         
         double b;
         
         System.out.println("\nEnter amount spend on tution fee of  1 or 2 childer :");
         float st=bc.nextFloat();
         
         System.out.println("Enter amount paid on Life insurance premium :");
         float sp=bc.nextFloat();
         
         System.out.println("Enter amount Deposit in provident fund/superannuation fund :");
         float sd=bc.nextFloat();
         
         System.out.println("Enter amount Investment in fixed deposit/Bonds :");
         float si=bc.nextFloat();
         
         System.out.println("Enter amount invested in NSC :");
         float sn=bc.nextFloat();
         
         System.out.println("Enter amount paid in repayment of princpal of houseloan :");
         float sl=bc.nextFloat();
         
         System.out.println("Enter amount invested in mutalfund which comes under sec 80C :");
         float sm=bc.nextFloat();
         
         System.out.println("Enter amount spent on stampduty/registration fee of house :");
         float sr=bc.nextFloat();
         
         System.out.println("Enter amount invested in other investments which comes under sec 80C :");
         float so=bc.nextFloat();
         
         float C = st+sp+sd+si+sn+sl+sm+sr+so;
         
         if (C<=150000)
            b= t-C;
         else {
             b=t-150000;
             System.out.println("\nAccording to 80C Max Deduction is 1.5L,So 1.5L is deduted.");
         }
         
         interst(b);
         return b;
     }
     
// Interst on saveings account.   
     
     static double interst(double b)
     {
         Scanner xc= new Scanner (System.in);
         double c;
         
        System.out.println("\nEnter amount earned on Interst:");
        float ii=xc.nextFloat();
        
        if (ii<=10000)
            c=b-ii;
        else {
            c=b-10000;
            System.out.println("\nAccording to 80TTA MAX dedution on Interst enerned is 10K so 10K is deducted.");
        }
               
        helth_ins(c);
        return c;
     }
     
 // Health Insurance Premium.    
     
     static double helth_ins(double c)
     {
         double d=c;
         Scanner yc = new Scanner (System.in);
         
         System.out.println("\n Helth inusernce For Self / Spouse or Dependent Children :");
         float hi=yc.nextFloat();
         
         if(hi<=25000)
             d=d-hi;
         else {
             d=d-25000;
              System.out.println("\nAccording to 80D MAX deduction on Health Inusernce of self/spouse is 25K.");
         }
         
         System.out.println(" Helth inusernce For parents :");
         float ip=yc.nextFloat();
         
         if(ip<=25000)
             d=d-ip;
         else {
             d=d-25000;
              System.out.println("\nAccording to 80D MAX deduction on Health Inusernce of parents is 25K.");
         }
         
        Prof_tax(d);
         return d;
     }
  
 // professional tax and standard dedtion of 50000 and HRA. 
     
     static void Prof_tax(double d)
     {
         double f;
         Scanner xc= new Scanner (System.in);
         
         System.out.println("Amount paid on Professional tax :");
         float pt = xc.nextFloat();
         
         f=d-pt;
         f=f-50000;  //standered dedcution.
         
         System.out.println("HRA if its less then 60000 for annual enter it. else enter 60000");
         float hra=xc.nextFloat();
         
         f=f-hra;
         System.out.println("If you r takeing loan press 1 fund 2 else 0 :");
         int xx=xc.nextInt();
         
         if(xx==1)
             loan(f); 
         else if (xx==2)
             fund(f);
         else 
             otax(f);
     }

//deduction on interst paid on loan.
     
     static void loan(double f)
     {
         double g=f;
         Scanner wc= new Scanner(System.in);
         
         System.out.println("Enter the interst paid on higher edution loan :");
         float el=wc.nextFloat();
         g=g-el;
         
         System.out.println("Interst paid on 1st House loan : ");
         float hl=wc.nextFloat();
         if(hl<=150000)
             g=g-hl;
         else {
             g=g-150000;
             System.out.println("\nAccording to 80EEA MAX dedution on 1st house loan is 1.5L :");
         }
         
         System.out.println("Enter the interst paid on house loan (not 1st house):");
         float lh=wc.nextFloat();
         if(lh<=50000)
             g=g-lh;
         else {
             g=g-50000;
             System.out.println("\nAccording to 80EE MAX dedution on 1st house loan is 50K :");
         }
         
         System.out.println("Enter interst paid on electric vehicl loan :");
         float le= wc.nextFloat();
         if(el<=150000)
             g=g-le;
         else {
             g=g-150000;
             System.out.println("\nAccording to 80EEB MAX dedution on eletric vehicl loan is  1.5L :");
         }
         System.out.println("If you are donating any fund press 1 else 0 :");
         int xx=wc.nextInt();
         if(xx==1)
           fund(g);
         else
             otax(g);
         
     }
 
//deduction on amount funded.
     
     static double fund(double g)
     {
         double h=g;
         Scanner vs= new Scanner (System.in);
         
         System.out.println("Enter amount donted to funds/charitable Institution : ");
         float fc=vs.nextFloat();
         h=h-fc;
         
         System.out.println("Enter amount donted to scientific Reserch/Rural development :");
         float sc=vs.nextFloat();
         h=h-sc;
         
         System.out.println("Enter amount donted to political party :");
         float pp=vs.nextFloat();
         h=h-pp;
         
         otax(h);
         
         return h;
         
     }
// calucating tax by Existing Tax regime.
     
     static double otax(double h)
     {
         double e;
         if(h<500000)
             e=0;
         else if (h>=500000 && h<1000000)
             e=12500+(h-500000)*0.2;
         else 
             e=112500+(h-1000000)*0.3;
         
         e=e+tcgain;
         e=e+e*0.04;  // Education cess @ 4%
         
         System.out.println("\nTotal Income Inculded Captial gains "+Total_Income);
         System.out.println("Total Taxable Income by Existing Tax Regime :"+h);
         System.out.println("Tax on captical gains  :"+tcgain);
         System.out.println("Total Tax by Existing Tax Regime = "+e);
         return e;
     }
    
    public static void main (String args[]) throws Exception
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("                Welcome to Income Tax Calulator!!   ");
        System.out.println("\n\n Enter the amounts with respect to the qestion.");
        System.out.println("If any amount is not applicable for u enter 0. ");
        
        //Collecting Income From Salary.
        
        System.out.println("Enter amount earned on Salary :");
        float is=sc.nextFloat();
        
        System.out.println("If You Are Getting Income on prorety rent Press 1 : ");
        System.out.println("If You Are Getting Income From Captial gains press 2 :");
        System.out.println("If you get Income form both if these press 12 :");
        System.out.println("If you are not getting Income from these both press 0 :");
        
        int ip1=sc.nextInt();
        
       if(ip1==1 || ip1==12){
            
            // Collecting data about Income From Proprety Rent.
            
        System.out.println("Enter amount earned on proprety  rent :");
        float pr=sc.nextFloat();
        System.out.println("Enter amount paid on  Municipal Taxes Paid During the Year:");
        float mt=sc.nextFloat();
         pr1=pr-(pr*30/100)-mt;
        System.out.println("Total amount earned on proprety rent after dedution :"+pr1);
       }
        if(ip1==2 || ip1==12){
            
            //Collecting data about Income Frome Captital Gains.
            
        System.out.println("Enter Short Term Capital GainS (Other than covered under section 111A) :");
         sto=sc.nextFloat();
        System.out.println("Enter Short Term Capital GainS (Covered under section 111A) :");
         st=sc.nextFloat();
         stt=st*15/100;
        System.out.println("Enter Long Term Capital Gains (Charged to tax @ 20%) :");
         lt20=sc.nextFloat();
         lt20t=lt20*20/100;
        System.out.println("Enter Long Term Capital Gains (Charged to tax @ 10%) :");
         lt10=sc.nextFloat();
         lt10t=lt10*10/100;
        }
        
        //Collecting Income from Business Gains.
        
        System.out.println("Enter Profits and Gains of Business or Profession (enter profit only):");
        float bg = sc.nextFloat();
        
        //Collecting Income from Agricluter.
        
        System.out.println("Enter amount earned on Agriclutre ");
        float ai=sc.nextFloat();
        ai=0;
        
        //collecting Income from Other Soruces.
        
        System.out.println("Enter amout earned from other Soruces :");
        float os=sc.nextFloat();
        
        tcgain=stt+lt20t+lt10t;
        float Total=is+pr1+ai+os+sto+bg;
        Total_Income = is+pr1+ai+os+bg+sto+st+lt20+lt10;
        
        double taxn= New(Total);
        old(Total);
        
        //Printing Total Income and Total Tax Acc To New Tax Regime.
        
        System.out.println("\nTotal Income Including Captial Gains :"+Total_Income);
        System.out.println("Total Taxable Income by New TAx Regime u/s 115BAC ="+Total);
        System.out.println("Tax on Captial gain :"+tcgain);
        System.out.println("Total Tax by New Tax Regime u/s 115BAC = "+taxn);
    }
    
}

