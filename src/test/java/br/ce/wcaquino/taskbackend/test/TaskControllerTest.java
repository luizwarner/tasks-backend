package br.ce.wcaquino.taskbackend.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {
	
	@Mock
	private TaskRepo todoRepo;
	
	@InjectMocks
	TaskController taskController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void naoDeveSalvarTarefaSemDescricao(){
		Task task = new Task();
		task.setTask("teste!!!");
		task.setDueDate(LocalDate.of(1900, 01, 01));
		
		try {
			taskController.save(task);
		} catch (ValidationException e) {			
			e.printStackTrace();
			Assert.assertEquals("Fill the task description", e.getMessage());
		}
	}
}
