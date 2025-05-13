package Utilitarios;

public class utils {

	public static String OnlyNumbers(String numeroComotexto) {
		String retorno = "";

		for (int i = 0; i < numeroComotexto.length(); i++)
			if ("0123456789".contains(String.valueOf(numeroComotexto.charAt(i)))) {
				retorno += numeroComotexto.charAt(i);
			}

		return retorno;
	}

	public static boolean ValidacaoCPF(String CPF) {

		String cpfSemFormatacao = OnlyNumbers(CPF);

		// considera-se erro CPF"s formados por uma sequencia de numeros iguais
		if (cpfSemFormatacao.length() != 11 || cpfSemFormatacao.chars().distinct().count() == 1) {	// Verifica se todos os caracteres são iguais

			return false;
		}
		int digito;
		int soma;

		// 1º dígito
		soma = 0;

		for (int i = 0; i < 9; i++)
			soma = (cpfSemFormatacao.charAt(i) - 48) * (10 - i); // Subtrai 48 para ajustar de acordo com a tabela ASCII

		digito = 11 - (soma % 11);
		if (digito == 10)
			digito = 0;
		digito += 48;

		if ((char)digito != cpfSemFormatacao.charAt(9)) // Compara o primeiro digito encontrado
			return false;

		soma = 0;

		for (int i = 0; i < 10; i++)
			soma += (cpfSemFormatacao.charAt(i) - 48) * (11 - i);

		digito = 11 - (soma % 11);
		if (digito == 10)
			digito = 0;
		digito += 48;

		if ((char)digito != cpfSemFormatacao.charAt(10))
			return false;

		return true;
	}

}
