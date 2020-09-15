package com.example.treinamentojava;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class ExemplosDatas {

    private static final Logger LOGGER = Logger.getLogger(ExemplosDatas.class.getName());

    private static void exemplo_datas() {

        LocalTime agoraComHora = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agoraComHora);

        LocalDate anoPassado = LocalDate.now().minusYears(1);

        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12,0);

        LocalDate dataDoPassado = LocalDate.now().withYear(1988);

        LocalDate amanha = LocalDate.now().plusDays(1);

//      Diferença entre duas datas Java 7
//		Calendar agora = Calendar.getInstance();
//		Calendar outraData = Calendar.getInstance();
//		outraData.set(1988, Calendar.JANUARY, 25);
//		long diferenca = agora.getTimeInMillis() - outraData.getTimeInMillis();
//		long milissegundosDeUmDia = 1000 * 60 * 60 * 24;
//		long dias = diferenca / milissegundosDeUmDia;

//      Diferença entre duas datas Java 8
        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);

        long dias = ChronoUnit.DAYS.between(outraData, agora);
        long meses = ChronoUnit.MONTHS.between(outraData, agora);
        long anos = ChronoUnit.YEARS.between(outraData, agora);
        System.out.printf("%s dias, %s meses e %s anos", dias, meses, anos);

        //Validar peridos de datas
        Period periodo = Period.between(outraData, agora);
        if (periodo.isNegative()) {
            periodo = periodo.negated();
        }

        System.out.printf("%s dias, %s meses e %s anos",
                periodo.getDays(), periodo.getMonths(), periodo.getYears());
    }
}
