package com.prashanthgurunath.twitsplitapp;


import org.junit.Assert;
import org.junit.Test;


public class TwitSplitTest extends ChatFragment {


   private ChatFragment chatFragment;
   private String sampleString1=null;
   private String sampleString2="";
   private String sampleString3="Hello World";

   private String sampleString4="Ican'tbelieveTweeternowsupportschunkingmymessages,soIdon'thavetodoitmyself";

   private String sampleString5="Founded in 2012, ZALORA is known to be\n" +
           "                                     the fastest growing online fashion retailer in Asia.\n" +
           "                                     Localizing its products to fit the customer demands\n" +
           "                                     in different countries from Singapore, Malaysia & Brunei,\n" +
           "                                     Indonesia, Hong Kong, the Philippines and its new venture\n" +
           "                                     in Taiwan, ZALORA definitely brings you the trendiest fashion\n" +
           "                                     trends online. With over 500 international and local brands available\n" +
           "                                     on the site, customers can easily browse through the wide selection of\n" +
           "                                     clothes, accessories, bags and more while embracing the use of technology.\n" +
           "                                     You will always be able to keep tabs on the trend curve ahead of time with a\n" +
           "                                     click away while enjoying an amazing online shopping experience with ZALORA Malaysia.\n" +
           "                                     ZALORA is the one-stop online fashion destination with thousands of new products coming\n" +
           "                                     in every week to keep customers excited. Believing that your online shopping experience\n" +
           "                                     should be easy and fun, we offer speedy deliveries with 30 days free return policy as well as\n" +
           "                                     various payment methods.";


   private String sampleString6="IamPrashanthGurunath...Iam20yrsold";

   private Character character=' ';

    @Test
    public void inputStringNullCheck() {

       Assert.assertNull(sampleString1);
    }

    @Test
    public void inputStringEmptyCheck() {
        Assert.assertEquals("", sampleString2);
    }

    @Test
    public void inputStrLenTestCase1()     // input count<0
    {
        chatFragment=new ChatFragment();
        Assert.assertFalse(chatFragment.count(sampleString3)<0);
    }
    @Test
    public void inputStrLenTestCase2()   // no of spaces=50
    {
        chatFragment=new ChatFragment();
        Assert.assertFalse(chatFragment.getSpaceCount(sampleString4)==50);
    }
    @Test
    public void inputStrLenTestCase3()   // no of spaces>50
    {
        chatFragment=new ChatFragment();
        Assert.assertTrue(chatFragment.getSpaceCount(sampleString5)>50);
    }
    @Test
    public void inputStrLenTestCase4()   // no of spaces=0 & no of chars<=50
    {
        chatFragment=new ChatFragment();
        Assert.assertTrue(chatFragment.getSpaceCount(sampleString6)==0);
        Assert.assertTrue(chatFragment.count(sampleString6)<=50);

    }

    @Test
    public void isSpaceTest()  // to check if the isSpace(char c) funtion is working fine
    {
        chatFragment=new ChatFragment();
        Assert.assertEquals(true,chatFragment.isSpace(character));
    }

    @Test
    public void inputStringNonWhiteSpaceTest()  // to check if the string has a set of non white space characters>50
    {
        chatFragment=new ChatFragment();
        Assert.assertEquals(chatFragment.nonWhiteSpaceChar(sampleString4),true);
        Assert.fail("Error. Message contains a span of non-whitespace characters longer than 50 characters");

    }


}  // end of class
