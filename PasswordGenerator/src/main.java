import java.security.SecureRandom;

public class main 
{
	
	public class PassowortGenerator 
	{
		private static final SecureRandom secureRandom = new SecureRandom();
		private static final String letters = "abcdefghijklmnopqrstuvwxyz";
		private static final String lettersCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		private static final String numbers = "0123456789";
		private static final String specials = "!§$%&/()=?.:,;+*#<>";

	public enum CharacterSet 
	{
		Letters,
		LettersCaps,
		LettersBoth,
		Numbers,
		LetterNumber,
		Special,
		All
	}

	private static String getCharacters(CharacterSet characterSet) 
	{

		switch (characterSet) 
		{
		case Letters:
		return letters;
		case LettersCaps:
		return lettersCaps;
		case LettersBoth:
		return letters + lettersCaps;
		case Numbers:
		return numbers;
		case LetterNumber:
		return letters + lettersCaps + numbers;
		case Special:
		return specials;
		case All:
			return letters + lettersCaps + numbers + specials;
		}

		return letters;
	}

	public static String generatePassword(int length, CharacterSet characterSet) 
	{
	String characters = getCharacters(characterSet);
	StringBuilder stringBuilder = new StringBuilder();

	for (int i = 0; i < length; i++) 
	{
	stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
	}
		return stringBuilder.toString();
	}
		    
	public static void main(String[] args)
	{
	String s = PassowortGenerator.generatePassword(10, PassowortGenerator.CharacterSet.All); //The 10 is the length of the password
	System.out.println(s); //The password is issued via the terminal.	
	}
	
	}
}
