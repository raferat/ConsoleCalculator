package cz.martin.consolecalculator;

import java.util.ArrayList;

public class Tokenizer
{
  ArrayList<Type> output = new ArrayList<>();
  String text;
  
  public static enum Type
  {
    Number(),
    Minus(),
    Plus(),
    Times(),
    Devide()
  }
  
  public TokenizerReturnValues tokenize ( String text )
  {
    this . text = text;
    output.clear ();
    int parseIndex = 0;
    int charIndex = 0;
    
    while ( charIndex < text . length () )
    {
      char c = text . charAt ( charIndex );
      switch ( parseIndex )
      {
        case 0:
          if ( isDigit ( c ) || c == '-' || c == '+' )
          {
            parseIndex = 1;
            break;
          }
          else
            return TokenizerReturnValues.ERROR;
          
        case 1:
          if ( c == '-')
            parseIndex = 2;
          else
            parseIndex = 3;
          break;
        
        case 2:
          if ( isDigit ( c ) )
            parseIndex = 3;
          else
          {
            output.add ( Type.Minus );
            charIndex ++;
          }
          break;
        
        case 3:
          if ( isDigit ( c ) )
          {
            output.add ( Type.Number );
            charIndex ++;
            parseIndex = 4;
          }
          else if ( c == '+' )
          {
            output.add ( Type.Plus );
            charIndex ++;
            parseIndex = 4;
          }
          else if ( c == '-' )  
          {
            output.add ( Type.Minus );
            charIndex ++;
            parseIndex = 4;
          }
          else if ( c == '*' )
          {
            output.add ( Type.Times );
            charIndex ++;
            parseIndex = 4;
          }
          else if ( c == '/' )
          {
            output.add ( Type.Devide );
            charIndex ++;
            parseIndex = 4;
          }
          
          
          break;
          
        case 4:
          if ( isOperation ( c ) )
          {
            parseIndex = 3;
          }
          else if ( isDigit ( c ) )
          {
            output.add ( Type.Number );
            charIndex ++;
          }
      }
    }
    
    return TokenizerReturnValues.CORRECT;
  }
  
  private static boolean isOperation ( char c )
  {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }
  
  private static boolean isDigit (char c)
  {
    return c >= '0' && c <= '9';
  }
  
}
