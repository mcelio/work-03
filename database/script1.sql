CREATE TABLE DAYOFF(ID INT PRIMARY KEY,
   DAY DATE, DESCRIPTION VARCHAR(255));
  
INSERT INTO DAYOFF VALUES(1, DATE '2015-01-01', 'feriado nacional –Confraternização universal');
INSERT INTO DAYOFF VALUES(2, DATE '2015-02-20', '​ponto facultativo –Carnaval');
INSERT INTO DAYOFF VALUES(3, DATE '2015-02-21', 'ponto facultativo –Carnaval');
INSERT INTO DAYOFF VALUES(4, DATE '2015-02-22', 'ponto facultativo até as 14 horas–Quarta-feira de Cinzas');
INSERT INTO DAYOFF VALUES(5, DATE '2015-04-06', 'ponto facultativo –Paixão de Cristo');
INSERT INTO DAYOFF VALUES(6, DATE '2015-04-21', 'feriado nacional –Tiradentes');
INSERT INTO DAYOFF VALUES(7, DATE '2015-05-01', '​feriado nacional –Dia Mundial do Trabalho');
INSERT INTO DAYOFF VALUES(8, DATE '2015-06-07', 'ponto facultativo –Corpus Christi');
INSERT INTO DAYOFF VALUES(9, DATE '2015-09-07', 'feriado nacional –Independência do Brasil');
INSERT INTO DAYOFF VALUES(10, DATE '2015-10-12', '​feriado nacional –Nossa Senhora Aparecida');
INSERT INTO DAYOFF VALUES(11, DATE '2015-10-28', 'ponto facultativo –Diado Servidor Público');
INSERT INTO DAYOFF VALUES(12, DATE '2015-11-02', '​feriado nacional –Finados');
INSERT INTO DAYOFF VALUES(13, DATE '2015-11-15', '​feriado nacional –Proclamação da República');
INSERT INTO DAYOFF VALUES(14, DATE '2015-12-24', 'ponto facultativo –Vésperado Natal');
INSERT INTO DAYOFF VALUES(15, DATE '2015-12-25', '​feriado nacional –Natal');
INSERT INTO DAYOFF VALUES(16, DATE '2015-12-31', 'ponto facultativo –VésperadeAno-Novo');
COMMIT;