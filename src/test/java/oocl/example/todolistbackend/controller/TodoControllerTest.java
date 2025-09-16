package oocl.example.todolistbackend.controller;

import oocl.example.todolistbackend.entity.TodoEntity;
import oocl.example.todolistbackend.repository.TodoRepository;
import oocl.example.todolistbackend.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp(){
        todoRepository.clear();
    }

    @Test
    void should_return_todo_list() throws Exception {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setText("learn spring");
        todoEntity.setDone(false);
        todoRepository.addTodo(todoEntity);
        TodoEntity todoEntity2 = new TodoEntity();
        todoEntity2.setText("learn 2");
        todoEntity2.setDone(false);
        todoRepository.addTodo(todoEntity2);

        mockMvc.perform(get("/todos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(todoEntity.getId()))
                .andExpect(jsonPath("$[0].text").value("learn spring"))
                .andExpect(jsonPath("$[1].id").value(todoEntity2.getId()))
                .andExpect(jsonPath("$[1].text").value("learn 2"));
    }

    @Test
    void should_return_todoEntity_when_create_todo_given_todo_correct_attribute() throws Exception{
        String requestBody = """
                {
                    "text": "learn English"
                }
                """;

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.text").value("learn English"))
                .andExpect(jsonPath("$.done").value(false));
    }

    @Test
    void should_return_422_when_create_todo_given_todo_text_field_is_null() throws Exception{
        String requestBody = """
                {
                    "done": false
                }
                """;

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void should_return_422_when_create_todo_given_todo_text_field_is_empty() throws Exception{
        String requestBody = """
                {
                    "text": ""
                }
                """;

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }

    


}