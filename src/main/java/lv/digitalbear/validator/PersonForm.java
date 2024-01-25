package lv.digitalbear.validator;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
	@NotNull
	@Size(min=2, max=30)
	private String name;

	@NotNull
	@Min(18)
	private Integer age;

}
