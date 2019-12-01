package com.kata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import com.kata.api.controller.KataController;
import com.kata.service.impl.KataServiceImpl;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureMockMvc
@Transactional
@RunWith(SpringRunner.class)
public class KataControllerTest {

	@Autowired
	private KataServiceImpl kataService;
    
    @Autowired
    private MockMvc mockMvc;
    
    public static final String KATA_JSON = "";
    public static final Integer KATA_ID_EXISTED = 1;
    public static final Integer KATA_ID_UNKNOWED = 9999999;
            
    @Test
    public void whenGetRequestGetAllKatas() throws Exception {
    	String uri = KataController.API_ROOT_RESOURCE + "/getAllkatas";
    	 mockMvc.perform(get(uri)
    			 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    
        
//    @Test
//    public void whenPostRequestToKatasAndValidUser_thenCorrectResponse() throws Exception {
//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//        String kata = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post(kataController.API_ROOT_RESOURCE + "/getAllkatas")
//                .content(kata)
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
//    }
//    
//    @Test
//    public void whenPostRequestToKatasAndInValidUser_thenCorrectReponse() throws Exception {
//        String kata = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post(kataController.API_ROOT_RESOURCE + "/getAllkatas")
//                .content(kata)
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
//    }
    
    
    
}
