package com.example.treinamentojava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.logging.Logger;

public class ExemplosDatas {

    private static final Logger LOGGER = Logger.getLogger(ExemplosDatas.class.getName());


    public void agora(){
        LocalDate agora = LocalDate.now();
        LOGGER.info("Datas: agora: "+agora);
    }
    public void dataHora(){
        LocalTime agoraComHora = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agoraComHora);
        LOGGER.info("Datas: Data - Hora: "+dataEhora);
    }

    public void proximoMes(){
        Calendar proximoMes = Calendar.getInstance();
        proximoMes.add(Calendar.MONTH, 1);
        LOGGER.info("Datas: proximo mês: "+proximoMes.getTime());
    }

    public void anoPassado(){
        LocalDate anoPassado = LocalDate.now().minusYears(1);
        LOGGER.info("Datas: ano passado: "+anoPassado);
    }

    public void hojeAoMeioDia(){
        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12,0);
        LOGGER.info("Datas: hoje ao meio dia: "+hojeAoMeioDia);
    }

    public void dataDoPassado(){
        LocalDate dataDoPassado = LocalDate.now().withYear(1988);
        LOGGER.info("Datas: data do passado: "+dataDoPassado.getYear());
    }

    public void amanha(){
        LocalDate amanha = LocalDate.now().plusDays(1);
        LOGGER.info("Datas: amanha: "+amanha);
    }

    public void outraData(){
        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
        LOGGER.info("Datas: amanha: "+outraData);

    }

    public void between() {

        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(2022, Month.AUGUST, 18);

        Period periodo = Period.between(outraData, agora);
        if (periodo.isNegative()) {
            periodo = periodo.negated();
        }

        LOGGER.info("Datas: between:"+periodo.getDays()+" dias "+periodo.getMonths()+" meses "+periodo.getYears()+" anos ");

        System.out.printf("%s dias, %s meses e %s anos",
                periodo.getDays(), periodo.getMonths(), periodo.getYears());
    }

    public void format() {
        LocalDate agora = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = agora.format(formatador);
        LOGGER.info("Datas: data formatada :"+dataFormatada);
    }

}
