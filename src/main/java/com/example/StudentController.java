package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repository;

	@Autowired
	CourseRepository courserepo;

	@RequestMapping("/student/{id}")
	public String student(@PathVariable Long id, Model model) {
        model.addAttribute("student", repository.findById(id).orElse(null));
        model.addAttribute("courses", courserepo.findAll());
        return "student";
	}

    @RequestMapping(value="/students",method=RequestMethod.GET)
	public String studentsList(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
	}
    
    @RequestMapping(value="/stud",method=RequestMethod.GET)
    public String studentRedirect(Model model) {
    	model.addAttribute("students", repository.findAll());
        return "redirect:/students";
    }

    @RequestMapping(value="/students",method=RequestMethod.POST)
	public String studentsAdd(@RequestParam String srn, 
						@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Student newStudent = new Student();
        newStudent.setSRN(srn);
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        repository.save(newStudent);

        model.addAttribute("student", newStudent);
        model.addAttribute("courses", courserepo.findAll());
        return "redirect:/student/" + newStudent.getId();
	}

    @RequestMapping(value="/student/{id}/courses", method=RequestMethod.POST)
	public String studentsAddCourse(@PathVariable Long id, @RequestParam Long courseId, Model model) {
    	Course course = courserepo.findById(courseId).orElse(null);
    	Student student = repository.findById(id).orElse(null);;

 
    	if (student != null) {
    		if (!student.hasCourse(course)) {
    			student.getCourses().add(course);
    		}
    		repository.save(student);
            model.addAttribute("student", repository.findById(id).orElse(null));
            model.addAttribute("courses", courserepo.findAll());
            //return "redirect:/student/" + student.getId();
    	}

        model.addAttribute("students", repository.findAll());
        return "redirect:/students";
    }

}
