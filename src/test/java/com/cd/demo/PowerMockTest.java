//package com.cd.demo;
//
//import com.cd.demo.powermock.FileDemo;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import java.io.File;
//
//import static org.powermock.api.mockito.PowerMockito.mock;
//
//@RunWith(PowerMockRunner.class)
//public class PowerMockTest {
//
//    @Test
//    public void createFileTest () {
//
//        File file = mock(File.class);
//        PowerMockito.when(file.exists()).thenReturn(true);
//
//        FileDemo fileDemo = new FileDemo();
//        Assert.assertTrue(fileDemo.createFile(file));
//    }
//
////    @PrepareForTest(FileDemo.class)
////    @Test
////    public void mockStaticMethod () {
////
////        File file = PowerMockito.mock(File.class);
////
////        try {
////            PowerMockito.whenNew(File.class).withArguments("bb").thenReturn(file);
////            FileDemo fileDemo = new FileDemo();
////
////            PowerMockito.when(file.exists()).thenReturn(true);
////            Assert.assertTrue(fileDemo.createNewFile("bb"));
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
