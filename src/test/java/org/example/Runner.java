package org.example;


import org.testng.annotations.Test;


public class Runner {

    PreRequisites pre;
    ChoosingAFlight cf ;
    FlexibleDate fd ;

    public Runner(){
        pre = new PreRequisites();
        cf = new ChoosingAFlight();
        fd = new FlexibleDate();
    }






    @Test(priority = 1)
    public void openAndNavigate(){

        pre.openAndNavigate();

    }



    @Test(priority = 2)
    public void choosingAFlight() throws InterruptedException {

        cf.choosingAFlight();

    }
    @Test(priority = 3)
    public void navigateToFlexibleDate() throws InterruptedException {
       fd.navigateToFlexibleDate();

    }





    @Test(priority = 4)
    public void closeBrowser(){
       pre.closeBrowser();

    }
}
