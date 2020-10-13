package com.demo.tests;

import com.demo.baseTest.BaseTest;
import org.testng.annotations.Test;

public class KbcTest extends BaseTest {

    @Test
    public void selectRadio(){
        kbc.selectRadioOne();
        kbc.populateSavingsAmount("300");
        kbc.selectDDMenu();
//        kbc.selectDDItem();
        kbc.pickRandomDDItem();
    }
}
