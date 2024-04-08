package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Dependente;
import persistence.DependenteDao;
import persistence.GenericDao;

public class DependenteController {

	@Autowired
	GenericDao gDao;

	@Autowired
	DependenteDao dDao;

	@RequestMapping(name = "Dependente", value = "/dependente", method = RequestMethod.GET)
	public ModelAndView dependenteGet(ModelMap model) {
		return new ModelAndView("dependente");
	}

	@RequestMapping(name = "Dependente", value = "/dependente", method = RequestMethod.POST)
	public ModelAndView dependentePost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		String cod = allRequestParam.get("codigo");
		String saida = "";
		String erro = "";
		List<Dependente> dependentes = new ArrayList<>();

		try {
			if (cod.trim() != "") {
				dependentes = list(cod);
				saida = "aluno cadastrado";
			} else {
				saida = "codigo não pode ser nulo";
			}
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("dependentes", dependentes);
		}
		return new ModelAndView("dependente");
	}

	private List<Dependente> list(String cod) throws ClassNotFoundException, SQLException {
		DependenteDao dDao = new DependenteDao(gDao);
		return dDao.list(cod);
	}
}
