package cz.martin.consolecalculator;

import java.util.Scanner;

public class Calc
{

  /**
   * @param args the command line arguments
   */
  public static void main ( String[] args )
  {
    Tokenizer t = new Tokenizer ();
    Scanner s = new Scanner (System.in);
    while ( t . tokenize ( s . next () ) == TokenizerReturnValues.CORRECT )
    {
      for ( int i = 0 ; i < t.output.size () ; i ++ )
      {
        Tokenizer.Type type = t.output.get ( i );
        switch ( type )
        {
          
        }
      }
    }
  }
  
  private static int findPrimaryOperator ( Tokenizer t )
  {
    return 0;
  }
}
