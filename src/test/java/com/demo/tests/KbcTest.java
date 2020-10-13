package com.demo.tests;

import com.demo.baseTest.BaseTest;
import org.testng.annotations.Test;

public class KbcTest extends BaseTest {

    @Test
    public void selectRadio(){
        initKBC();
        kbc.selectRadioOne();
        kbc.populateSavingsAmount();
        kbc.selectDDMenu();
        kbc.getListOfItems();
        kbc.pickDDItem();
        kbc.clickCalculateBtn();
    }
}
