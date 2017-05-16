--coltura successiva
SELECT c_successiva.nome, c_precedente.nome FROM coltura AS c_successiva JOIN (rotazione JOIN coltura AS c_precedente ON rotazione.idfamiglia=c_precedente.idfamiglia) ON rotazione.idfamigliarot=c_successiva.idfamiglia WHERE c_precedente.nome="Lattuga";
--coltura precendete
SELECT c_successiva.nome, c_precedente.nome FROM coltura AS c_successiva JOIN (rotazione JOIN coltura AS c_precedente ON rotazione.idfamiglia=c_precedente.idfamiglia) ON rotazione.idfamigliarot=c_successiva.idfamiglia WHERE c_successiva.nome="Lattuga";
--coltura per appezzamento
SELECT appezzamento.nome, coltura.nome FROM appezzamento JOIN (appezzamentocoltura JOIN coltura ON appezzamentocoltura.idcoltura=coltura.id) ON appezzamento.id=appezzamentocoltura.idappezzamento;