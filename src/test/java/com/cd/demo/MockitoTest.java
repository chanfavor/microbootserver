package com.cd.demo;

import com.cd.demo.mockitio.Person;
import com.cd.demo.mockitio.PersonService;
import com.cd.demo.mockitio.PersonDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MockitoTest {

    @Before
    public void beforeTest () {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private PersonDao personDao;
    @Mock
    private PersonDao personDao2;
    @InjectMocks
    private PersonService personService;

    @Test
    public void commonTest () {

        /** 1. mock接口**/
        List mockList = mock(List.class);
        mockList.add(1);
        mockList.add("hello");
        mockList.add("hello");
        mockList.clear();

        verify(mockList, times(1)).add(1);
        verify(mockList).add(1);   // 同上等价
        verify(mockList, times(2)).add("hello");
        verify(mockList, atLeastOnce()).add("hello");
        verify(mockList).clear();


        /** 2. mock具体的类**/
        LinkedList mockLinkedlist = mock(LinkedList.class);
        when(mockLinkedlist.get(0)).thenReturn("first");
        when(mockLinkedlist.get(1)).thenReturn(new RuntimeException());
        System.out.println(mockLinkedlist.get(0));

        /** 这里没有设置，返回null **/
        System.out.println(mockLinkedlist.get(999));

        /**一般不需要直接打印具体的值，直接verify校验即可**/
        verify(mockLinkedlist).get(0);

        /**3. mock参数匹配**/
        LinkedList mockedList = mock(LinkedList.class);
        //用内置的参数匹配器来stub
        when(mockedList.get(anyInt())).thenReturn("element");

        //打印 "element"
        System.out.println(mockedList.get(999));
        Assert.assertEquals("element", mockedList.get(999));

        //你也可以用参数匹配器来验证，此处测试通过
        verify(mockedList, times(2)).get(anyInt());
        //此处测试将不通过，因为没调用get(33)
        // verify(mockedList).get(eq(33));
    }

    @Test
    public void throwExceptionTest () throws Exception {

        LinkedList mockList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockList).clear();
        mockList.clear();
    }

    @Test
    public void spyTest () {

        List linkedList = new LinkedList();
        List spy = spy(linkedList);
        when(spy.size()).thenReturn(100);
        spy.add(1);
        spy.add(2);

        System.out.println(spy.size());
        verify(spy).add(1);
        verify(spy).add(2);

//        when(spy.get(10)).thenReturn("foo");
        doReturn("foo").when(spy).get(10);
        System.out.println(spy.get(10));

    }

    @Test
    public void personServiceTest () {

        PersonDao personDao = mock(PersonDao.class);
        PersonService personService = new PersonService(personDao);
        when(personDao.getPersonById(1)).thenReturn(new Person(1, "cd"));
        System.out.println(personService.getPerson(1));
    }

    @Test
    public void personServiceTest2 () {

        when(personDao.getPersonById(anyInt())).thenReturn(new Person(2, "jerry"));
//        PersonService personService = new PersonService();
        System.out.println(personService.getPerson(1));
    }

}
