package com.group.demo.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ThingControllerTest {



    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private MockHttpSession session;// 1.Define a field to save the session

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session=new MockHttpSession();
    }


    @Test
    public void queryAllThingTest() throws Exception {
        // 登陆
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userName", "test")
                        .param("password", "123")
                        .session(session)
        );




        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/thing/queryall")
                        .session(session)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println((mvcResult.getResponse().getContentAsString()));
    }



    @Test
    public void queryByTypeTest() throws Exception {
        // 登陆
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userName", "test")
                        .param("password", "123")
                        .session(session)
        );




        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/thing/querybytype")
                        .param("type","Recycling")
                        .session(session)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println((mvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void queryTypesTest() throws Exception {
        // 登陆
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userName", "test")
                        .param("password", "123")
                        .session(session)
        );




        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/thing/queryTypes")
                        .session(session)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println((mvcResult.getResponse().getContentAsString()));
    }



}
