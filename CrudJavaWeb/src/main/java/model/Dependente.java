package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dependente {
	private String codFuncionario;
	private String nome;
	private float salario;
}
