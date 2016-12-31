package org.springframework.samples.mvc.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ValidationController {

	// enforcement of constraints on the JavaBean arg require a JSR-303 provider on the classpath
	
	@RequestMapping("/validate")
	public @ResponseBody String validate(@Valid JavaBean bean, BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> list = result.getFieldErrors();
			StringBuilder sb = new StringBuilder() ;
			for (FieldError err : list) {
				sb.append("<BR>[");
				sb.append(err.getField()).append("]=");
				sb.append("[").append(err.getDefaultMessage()).append("]");
			}
			return "Object has validation errors: (" + result.getErrorCount() + ") =" + sb.toString();
		} else {
			return "No errors";
		}
	}

}
