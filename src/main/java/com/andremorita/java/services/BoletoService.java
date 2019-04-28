package com.andremorita.java.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.andremorita.java.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagamento, Date instance) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instance);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagamento.setDataPagamento(cal.getTime());
	}

}
