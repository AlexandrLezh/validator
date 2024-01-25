package lv.digitalbear.validator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

@Controller
public class WebController implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/reg")
	public String showMain(User user) {
		return "main";
	}
	@PostMapping("/reg")
	public String checkReg(@Valid User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

			model.mergeAttributes(errors);
			return "main";
		}

		return "redirect:/results";
	}

	@GetMapping("/free")
	public String showMFree(User user) {
		return "free";
	}
	@PostMapping("/free")
	public String checkFree(@Valid User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

			model.mergeAttributes(errors);
			return "free";
		}

		return "redirect:/results";
	}

	@GetMapping("/log")
	public String showForm(PersonForm personForm) {
		return "form";
	}
	@PostMapping("/log")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

			model.mergeAttributes(errors);
			return "form";
		}

		return "redirect:/results";
	}
}
