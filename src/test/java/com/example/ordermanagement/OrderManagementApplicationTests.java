package com.example.ordermanagement;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class OrderManagementApplicationTests {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private StockManagementService productService;
//
//    @Autowired
//    private ProductOrderService orderService;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
//        Mockito.when(productService.getProductById()).thenReturn("Mock Product Name");
//        String testName = orderService.fetchProductOrderById();
//        Assert.assertEquals("Mock Product Name", testName);
//    }
//
//    @Test
//    public void givenUser_whenGetUser_thenReturnJsonArray()
//            throws Exception {
//
//        User alex = new User();
//
//        List<User> allUsers = Arrays.asList(alex);
//
//        given(userService.fetchAllUsers()).willReturn(allUsers);
//
//        mvc.perform(get("/api/v1/user")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getName())));
//    }

}
