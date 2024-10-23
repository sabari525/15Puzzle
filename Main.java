import java.util.*;
class Main{
    
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);        
        // System.out.print("Enter number of row: ");
        // n = sc.nextInt();
        Puzzle p =new Puzzle(3);
        boolean b = true;
        // p.reverseCol(n/2);
        do { 
            p.display();
            System.out.println("Choose Move direction:\n Up => W \n Right => D \n Left ->A\n Down => S\n Close => X");
            String choice = sc.next();
            switch(choice.toUpperCase()) {
                case "W":
                    if(p.Row + 1 < p.size)
                        b = p.up();
                    else
                        System.out.println("------------------------------Invalid Move!!");
                    break;
                case "S":
                    if(p.Row - 1 >= 0)
                        b = p.down();
                    else
                        System.out.println("------------------------------Invalid Move!!");
                    break;
                case "D":
                    if(p.Col-1 >= 0 )
                        b = p.right();
                    else
                        System.out.println("------------------------------Invalid Move!!");
                    break;
                case "A":
                    if(p.Col+1 < p.size)
                        b = p.left();
                    else
                        System.out.println("------------------------------Invalid Move!!");
                    break;
                case "X":
                    System.out.println("------------------------------Closed!!");
                    b = false;
                    break;
                default:
                    System.out.println("------------------------------Invalid Input!!");
                    break;
            }
        } while (b);
        // Puzzle p = new Puzzle(n);
        // p.display();

    }
}