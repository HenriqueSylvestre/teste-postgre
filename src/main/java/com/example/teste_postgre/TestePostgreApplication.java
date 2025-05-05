package com.example.teste_postgre;

import com.example.teste_postgre.infrastructure.repositories.EstruturaAtendimentoRepository;
import com.example.teste_postgre.infrastructure.repositories.PotencializadorRepository;
import com.example.teste_postgre.infrastructure.repositories.models.EstruturaAtendimento;
import com.example.teste_postgre.infrastructure.repositories.models.EstruturaAtendimentoId;
import com.example.teste_postgre.infrastructure.repositories.models.Potencializador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication(scanBasePackages = "com.example.teste_postgre")
public class TestePostgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestePostgreApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PotencializadorRepository potencializadorRepo, EstruturaAtendimentoRepository estruturaRepo) {
		return args -> {
			final var total = 100000;
			final var batchSize = 10000;
			Random random = new Random();
			Set<UUID> idContasSet = new HashSet<>();
			Set<UUID> clientesSet = new HashSet<>();
			List<UUID> idContasList = new ArrayList<>();
			List<String> funcionais = new ArrayList<>();

			// Gerar 10000 funcionais para cobrir 5.000.000 / 500 contas
			int totalFuncionais = total / 500;
			for (int i = 0; i < totalFuncionais; i++) {
				String funcional = String.format("%09d", random.nextInt(1_000_000_000));
				funcionais.add(funcional);
			}

			int index = 0;
			while (index < total) {
				List<Potencializador> batchPotencializadores = new ArrayList<>();
				List<EstruturaAtendimento> batchEstrutura = new ArrayList<>();

				for (int i = 0; i < batchSize && index < total; i++, index++) {
					UUID idConta = UUID.randomUUID();
					UUID cliente = UUID.randomUUID();

					if (idContasSet.contains(idConta) || clientesSet.contains(cliente)) continue;

					idContasSet.add(idConta);
					clientesSet.add(cliente);
					idContasList.add(idConta);

					Potencializador p = new Potencializador();
					p.setIdConta(idConta);
					p.setCliente(cliente);
					p.setCodigoBanco("341");
					p.setTipoEmpresa("0001");
					p.setAgencia(String.format("%04d", random.nextInt(10000)));
					p.setConta(String.format("%07d", random.nextInt(10000000)));
					p.setDigito(String.valueOf(random.nextInt(10)));

					p.setVariavel1(BigDecimal.valueOf(1.0));
					p.setRankingVariavel1(index + 1);
					p.setVariavel2(BigDecimal.valueOf(2.0));
					p.setRankingVariavel2(index + 1);
					p.setVariavel3(BigDecimal.valueOf(3.0));
					p.setRankingVariavel3(index + 1);
					p.setVariavel4(BigDecimal.valueOf(4.0));
					p.setRankingVariavel4(index + 1);
					p.setVariavel5(BigDecimal.valueOf(5.0));
					p.setRankingVariavel5(index + 1);
					p.setVariavel6(BigDecimal.valueOf(6.0));
					p.setRankingVariavel6(index + 1);
					p.setVariavel7(BigDecimal.valueOf(7.0));
					p.setRankingVariavel7(index + 1);
					p.setVariavel8(BigDecimal.valueOf(8.0));
					p.setRankingVariavel8(index + 1);
					p.setVariavel9(BigDecimal.valueOf(9.0));
					p.setRankingVariavel9(index + 1);
					p.setVariavel10(BigDecimal.valueOf(10.0));
					p.setRankingVariavel10(index + 1);
					p.setVariavel11(BigDecimal.valueOf(11.0));
					p.setRankingVariavel11(index + 1);
					p.setVariavel12(BigDecimal.valueOf(12.0));
					p.setRankingVariavel12(index + 1);
					p.setVariavel13(BigDecimal.valueOf(13.0));
					p.setRankingVariavel13(index + 1);
					p.setVariavel14(BigDecimal.valueOf(14.0));
					p.setRankingVariavel14(index + 1);
					p.setVariavel15(BigDecimal.valueOf(15.0));
					p.setRankingVariavel15(index + 1);

					batchPotencializadores.add(p);

					String funcional = funcionais.get(index / 500);
					String carteira = "E" + String.format("%04d", random.nextInt(10000));
					EstruturaAtendimento ea = new EstruturaAtendimento(funcional, idConta);
					ea.setCarteira(carteira);
					ea.setSegmento(index % 2 == 0 ? "ion" : "private");
					batchEstrutura.add(ea);
				}

				potencializadorRepo.saveAll(batchPotencializadores);
				estruturaRepo.saveAll(batchEstrutura);
			}
		};
	}

//	@Bean
//	CommandLineRunner init(PotencializadorRepository potencializadorRepo, EstruturaAtendimentoRepository estruturaRepo) {
//		return args -> {
//			final int total = 5_000_000;
//			final int batchSize = 10_000;
//
//			Random random = new Random();
//			Set<UUID> idContasSet = new LinkedHashSet<>();
//			Set<UUID> clientesSet = new LinkedHashSet<>();
//
//			List<Integer> rankings1 = gerarRankingUnico(total);
//			List<Integer> rankings2 = gerarRankingUnico(total);
//			List<Integer> rankings3 = gerarRankingUnico(total);
//			List<Integer> rankings4 = gerarRankingUnico(total);
//			List<Integer> rankings5 = gerarRankingUnico(total);
//			List<Integer> rankings6 = gerarRankingUnico(total);
//			List<Integer> rankings7 = gerarRankingUnico(total);
//			List<Integer> rankings8 = gerarRankingUnico(total);
//			List<Integer> rankings9 = gerarRankingUnico(total);
//			List<Integer> rankings10 = gerarRankingUnico(total);
//			List<Integer> rankings11 = gerarRankingUnico(total);
//			List<Integer> rankings12 = gerarRankingUnico(total);
//			List<Integer> rankings13 = gerarRankingUnico(total);
//			List<Integer> rankings14 = gerarRankingUnico(total);
//			List<Integer> rankings15 = gerarRankingUnico(total);
//
//			int index = 0;
//			List<Potencializador> batchList = new ArrayList<>();
//
//			while (index < total) {
//				UUID idConta = UUID.randomUUID();
//				UUID cliente = UUID.randomUUID();
//
//				if (idContasSet.contains(idConta) || clientesSet.contains(cliente)) continue;
//
//				idContasSet.add(idConta);
//				clientesSet.add(cliente);
//
//				Potencializador p = new Potencializador();
//				p.setIdConta(idConta);
//				p.setCliente(cliente);
//				p.setCodigoBanco("341");
//				p.setTipoEmpresa("0001");
//				p.setAgencia(String.format("%04d", random.nextInt(10000)));
//				p.setConta(String.format("%07d", random.nextInt(10_000_000)));
//				p.setDigito(String.valueOf(random.nextInt(10)));
//
//				p.setVariavel1(BigDecimal.valueOf(1.0));
//				p.setRankingVariavel1(rankings1.get(index));
//
//				p.setVariavel2(BigDecimal.valueOf(2.0));
//				p.setRankingVariavel2(rankings2.get(index));
//
//				p.setVariavel3(BigDecimal.valueOf(3.0));
//				p.setRankingVariavel3(rankings3.get(index));
//
//				p.setVariavel4(BigDecimal.valueOf(4.0));
//				p.setRankingVariavel4(rankings4.get(index));
//
//				p.setVariavel5(BigDecimal.valueOf(5.0));
//				p.setRankingVariavel5(rankings5.get(index));
//
//				p.setVariavel6(BigDecimal.valueOf(6.0));
//				p.setRankingVariavel6(rankings6.get(index));
//
//				p.setVariavel7(BigDecimal.valueOf(7.0));
//				p.setRankingVariavel7(rankings7.get(index));
//
//				p.setVariavel8(BigDecimal.valueOf(8.0));
//				p.setRankingVariavel8(rankings8.get(index));
//
//				p.setVariavel9(BigDecimal.valueOf(9.0));
//				p.setRankingVariavel9(rankings9.get(index));
//
//				p.setVariavel10(BigDecimal.valueOf(10.0));
//				p.setRankingVariavel10(rankings10.get(index));
//
//				p.setVariavel11(BigDecimal.valueOf(11.0));
//				p.setRankingVariavel11(rankings11.get(index));
//
//				p.setVariavel12(BigDecimal.valueOf(12.0));
//				p.setRankingVariavel12(rankings12.get(index));
//
//				p.setVariavel13(BigDecimal.valueOf(13.0));
//				p.setRankingVariavel13(rankings13.get(index));
//
//				p.setVariavel14(BigDecimal.valueOf(14.0));
//				p.setRankingVariavel14(rankings14.get(index));
//
//				p.setVariavel15(BigDecimal.valueOf(15.0));
//				p.setRankingVariavel15(rankings15.get(index));
//
//				batchList.add(p);
//				index++;
//
//				if (batchList.size() == batchSize || index == total) {
//					potencializadorRepo.saveAll(batchList);
//					batchList.clear();
//					System.gc(); // Libera memória
//					System.out.println("Inseridos: " + index);
//				}
//			}
//
//			// Criar vínculos com estrutura
//			List<UUID> idContasList = new ArrayList<>(idContasSet);
//			List<EstruturaAtendimento> estruturaBatch = new ArrayList<>();
//
//			for (int i = 0; i < 10; i++) {
//				String funcional = String.format("%09d", random.nextInt(1_000_000_000));
//				String carteira = "E" + String.format("%04d", random.nextInt(10_000));
//				for (int j = 0; j < 500; j++) {
//					int pos = i * 500 + j;
//					if (pos >= idContasList.size()) break;
//					EstruturaAtendimento ea = new EstruturaAtendimento(funcional, idContasList.get(pos));
//					ea.setCarteira(carteira);
//					ea.setSegmento((pos % 2 == 0) ? "ion" : "private");
//					estruturaBatch.add(ea);
//				}
//			}
//
//			estruturaRepo.saveAll(estruturaBatch);
//		};
//	}

	private List<Integer> gerarRankingUnico(int total) {
		List<Integer> ranking = new ArrayList<>();
		for (int i = 1; i <= total; i++) {
			ranking.add(i);
		}
		Collections.shuffle(ranking); // embaralha os rankings
		return ranking;
	}
}
