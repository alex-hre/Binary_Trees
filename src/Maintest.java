import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;



public class Maintest
{
	private static final long MEGABYTE = 1024L * 1024L;
	
	public static long bytesToMegabytes(long bytes)
    {
		return bytes / MEGABYTE;
	}


    public static void main(String [] args)
    {
        System.out.println("If you want to fill the file with random values - enter '1'\nIf not - enter any other number");
        Scanner fileChanger = new Scanner(System.in);
        int fullOrNo = fileChanger.nextInt();
        if(fullOrNo == 1)
        {
            File file = new File("SetNum.txt");
       
 
                try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8))
                {
                    for(int i = 0; i < 100000000; i++)
                    {
                        int number = (int) (Math.random()*100000000);
                        out.print(number + "\n");
                    }
                
                    System.out.println("Successfully written data to the file");
                }
                
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

        System.out.println("INCREASING ORDER - '1'\nDECREASING ORDER - '2'\nRANDOM - '3'");
		Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        switch(operation)
        {
            
            case(1)://increasing

                System.out.println("SPALY - '1'\nAVL - '2'");
                int numberCase1 = scanner.nextInt();
                
                switch(numberCase1)
                {
                    case(1)://Splay

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase1_1 = scanner.nextInt();
                        SplayTree bstCaseCase1 = new SplayTree();

                        Runtime runtime1_1 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime1_1.gc();

                        // Time counting
                        long c1 = System.currentTimeMillis();

                        for(int i = 0; numberCaseCase1_1 > i; i++)
                        {
                            bstCaseCase1.insert(i);
                        }

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c1));

                        // Calculate the used memory
                        long memory1_1 = runtime1_1.totalMemory() - runtime1_1.freeMemory();
                        System.out.println("Used memory is bytes: " + memory1_1);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory1_1));
                        
                        //bstCaseCase1.Visualisation();
                        
                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation1_1 = scanner.nextInt();
                
                        switch(nextOperation1_1)
                        {
                            case(1):


                                Runtime runtime1_11 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime1_11.gc();

                                long c11 = System.currentTimeMillis();

                                for(int i = 0; (numberCaseCase1_1)*0.5 > i; i++)
                                {
                                    bstCaseCase1.delete(i);
                                }
                                
                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c11));

                                // Calculate the used memory
                                long memory1_11 = runtime1_11.totalMemory() - runtime1_11.freeMemory();
                                System.out.println("Used memory is bytes: " + memory1_11);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory1_11));

                                //bstCaseCase1.Visualisation();

                                System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                                int nextOperation1_1_1 = scanner.nextInt();
                                

                                

                                if(nextOperation1_1_1 == 1)
                                {
                                    Runtime runtime1_111 = Runtime.getRuntime();
                                    // Run the garbage collector
                                    runtime1_111.gc();

                                    long c111 = System.currentTimeMillis();
                                    
                                    for(int i = 0; (numberCaseCase1_1)*0.5 > i; i++)
                                    {
                                        bstCaseCase1.search(i);
                                    }

                                    // Print time in millis
                                    System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));

                                    // Calculate the used memory
                                    long memory1_111 = runtime1_111.totalMemory() - runtime1_111.freeMemory();
                                    System.out.println("Used memory is bytes: " + memory1_111);
                                    System.out.println("Used memory is megabytes: "
                                    + bytesToMegabytes(memory1_111));

                                    //bstCaseCase1.Visualisation();
                                }

                            break;

                            case(2):
                            
                                Runtime runtime1_111 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime1_111.gc();

                                long c111 = System.currentTimeMillis();

                                for(int i = 0; (numberCaseCase1_1)*0.5 > i; i++)
                                {
                                    bstCaseCase1.search(i);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));

                                // Calculate the used memory
                                long memory1_111 = runtime1_111.totalMemory() - runtime1_111.freeMemory();
                                System.out.println("Used memory is bytes: " + memory1_111);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory1_111));


                                //bstCaseCase1.Visualisation();
                   
                            break;

                        }

                    break;

                    case(2)://AVL

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase1_2 = scanner.nextInt();
                        AVLTree bstCaseCase2 = new AVLTree();

                        Runtime runtime1_2 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime1_2.gc();

                        // Time counting
                        long c2 = System.currentTimeMillis();

                        for(int i = 0; numberCaseCase1_2 > i; i++)
                        {
                            bstCaseCase2.insert(i);
                        }

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c2));

                        // Calculate the used memory
                        long memory1_2 = runtime1_2.totalMemory() - runtime1_2.freeMemory();
                        System.out.println("Used memory is bytes: " + memory1_2);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory1_2));
                        
                        //bstCaseCase2.Visualisation();

                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation1_2 = scanner.nextInt();
                
                        switch(nextOperation1_2)
                        {
                            case(1):

                                Runtime runtime1_22 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime1_22.gc();
    
                                // Time counting
                                long c22 = System.currentTimeMillis();

                                for(int i = 0; (numberCaseCase1_2)*0.5 > i; i++)
                                {
                                    bstCaseCase2.delete(i);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c22));

                                // Calculate the used memory
                                long memory1_22 = runtime1_22.totalMemory() - runtime1_22.freeMemory();
                                System.out.println("Used memory is bytes: " + memory1_22);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory1_22));

                                //bstCaseCase2.Visualisation();

                                System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                                int nextOperation1_2_2 = scanner.nextInt();
                                
                                if(nextOperation1_2_2 == 1)
                                {
                                    
                                    Runtime runtime1_222 = Runtime.getRuntime();
                                    // Run the garbage collector
                                    runtime1_222.gc();
    
                                    // Time counting
                                    long c222 = System.currentTimeMillis();
                                    
                                    for(int i = 0; (numberCaseCase1_2)*0.5 > i; i++)
                                    {
                                        bstCaseCase2.search(i);
                                    }

                                    // Print time in millis
                                    System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c222));

                                    // Calculate the used memory
                                    long memory1_222 = runtime1_222.totalMemory() - runtime1_222.freeMemory();
                                    System.out.println("Used memory is bytes: " + memory1_222);
                                    System.out.println("Used memory is megabytes: "
                                    + bytesToMegabytes(memory1_222));

                                    //bstCaseCase2.Visualisation();

                                }

                            break;

                            case(2):
                            
                                Runtime runtime1_2222 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime1_2222.gc();

                                // Time counting
                                long c2222 = System.currentTimeMillis();

                                for(int i = 0; (numberCaseCase1_2)*0.5 > i; i++)
                                {
                                    bstCaseCase2.search(i);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c2222));

                                // Calculate the used memory
                                long memory1_2222 = runtime1_2222.totalMemory() - runtime1_2222.freeMemory();
                                System.out.println("Used memory is bytes: " + memory1_2222);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory1_2222));

                                //bstCaseCase2.Visualisation();
                   
                            break;

                        }

                    break;
                }
                

            break;

            case(2)://decreasing
                
                System.out.println("SPALY - '1'\nAVL - '2'");
                int numberCaseCase2 = scanner.nextInt();
                
                switch(numberCaseCase2)
                {
                    case(1)://Splay

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase2_1 = scanner.nextInt();
                        SplayTree bstCaseCase1 = new SplayTree();

                        Runtime runtime2_1 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime2_1.gc();

                        // Time counting
                        long c1 = System.currentTimeMillis();
                        
                        // save copy of data
                        int numberCaseCase2_1_copy = numberCaseCase2_1;
                        
                        for(int i = 0; numberCaseCase2_1 > i; numberCaseCase2_1--)
                        {
                            bstCaseCase1.insert(numberCaseCase2_1 -1);
                        }

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c1));


                        // Calculate the used memory
                        long memory2_1 = runtime2_1.totalMemory() - runtime2_1.freeMemory();
                        System.out.println("Used memory is bytes: " + memory2_1);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory2_1));
                        
                        //bstCaseCase1.Visualisation();

                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation2_1 = scanner.nextInt();
                        
                        //transfer data
                        numberCaseCase2_1 = numberCaseCase2_1_copy / 2;
                        
                        switch(nextOperation2_1)
                        {
                            case(1):

                                Runtime runtime2_11 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime2_11.gc();
    
                                // Time counting
                                long c11 = System.currentTimeMillis();

                                for(int i = 0; numberCaseCase2_1 > i; numberCaseCase2_1--)
                                {
                                    bstCaseCase1.delete(numberCaseCase2_1 - 1);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c11));


                                // Calculate the used memory
                                long memory2_11 = runtime2_11.totalMemory() - runtime2_11.freeMemory();
                                System.out.println("Used memory is bytes: " + memory2_11);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory2_11));

                                //bstCaseCase1.Visualisation();

                                System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                                int nextOperation2_1_1 = scanner.nextInt();
                                
                                //transfer data
                                numberCaseCase2_1 = numberCaseCase2_1_copy / 2;

                                if(nextOperation2_1_1 == 1)
                                {

                                    Runtime runtime2_111 = Runtime.getRuntime();
                                    // Run the garbage collector
                                    runtime2_111.gc();
    
                                    // Time counting
                                    long c111 = System.currentTimeMillis();

                                    for(int i = 0; numberCaseCase2_1 > i; numberCaseCase2_1--)
                                    {
                                        bstCaseCase1.search(numberCaseCase2_1 - 1);
                                    }

                                    // Print time in millis
                                    System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));


                                    // Calculate the used memory
                                    long memory2_111 = runtime2_111.totalMemory() - runtime2_111.freeMemory();
                                    System.out.println("Used memory is bytes: " + memory2_111);
                                    System.out.println("Used memory is megabytes: "
                                    + bytesToMegabytes(memory2_111));


                                    //bstCaseCase1.Visualisation();

                                }

                            break;

                            case(2):
                            
                                //transfer data
                                numberCaseCase2_1 = numberCaseCase2_1_copy / 2;
                                
                                Runtime runtime2_111 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime2_111.gc();
    
                                // Time counting
                                long c111 = System.currentTimeMillis();


                                for(int i = 0; numberCaseCase2_1 > i; numberCaseCase2_1--)
                                {
                                    bstCaseCase1.search(numberCaseCase2_1 - 1);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));


                                // Calculate the used memory
                                long memory2_111 = runtime2_111.totalMemory() - runtime2_111.freeMemory();
                                System.out.println("Used memory is bytes: " + memory2_111);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory2_111));

                                //bstCaseCase1.Visualisation();
                   
                            break;

                        }


                    break;

                    case(2)://AVL

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase2_2 = scanner.nextInt();
                        AVLTree bstCaseCase2 = new AVLTree();

                        // save copy of data
                        int numberCaseCase2_2_copy = numberCaseCase2_2;

                        Runtime runtime2_2 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime2_2.gc();

                        // Time counting
                        long c2 = System.currentTimeMillis();

                        for(int i = 0;numberCaseCase2_2  > i; numberCaseCase2_2--)
                        {
                            bstCaseCase2.insert(numberCaseCase2_2 - 1);
                        }

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c2));


                        // Calculate the used memory
                        long memory2_2 = runtime2_2.totalMemory() - runtime2_2.freeMemory();
                        System.out.println("Used memory is bytes: " + memory2_2);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory2_2));
                        
                        //bstCaseCase2.Visualisation();

                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation2_2 = scanner.nextInt();
                        
                        
                        //transfer data
                        numberCaseCase2_2 = numberCaseCase2_2_copy / 2;
                        
                        switch(nextOperation2_2)
                        {
                            case(1):

                                Runtime runtime2_22 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime2_22.gc();
    
                                // Time counting
                                long c22 = System.currentTimeMillis();

                                for(int i = 0; numberCaseCase2_2 > i; numberCaseCase2_2--)
                                {
                                    bstCaseCase2.delete(numberCaseCase2_2 - 1);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c22));


                                // Calculate the used memory
                                long memory2_22 = runtime2_22.totalMemory() - runtime2_22.freeMemory();
                                System.out.println("Used memory is bytes: " + memory2_22);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory2_22));

                                //bstCaseCase2.Visualisation();

                                System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                                int nextOperation2_1_1 = scanner.nextInt();
                                
                                //transfer data
                                numberCaseCase2_2 = numberCaseCase2_2_copy / 2;

                                if(nextOperation2_1_1 == 1)
                                {

                                    Runtime runtime2_222 = Runtime.getRuntime();
                                    // Run the garbage collector
                                    runtime2_222.gc();
    
                                    // Time counting
                                    long c222 = System.currentTimeMillis();

                                    for(int i = 0; numberCaseCase2_2 > i; numberCaseCase2_2--)
                                    {
                                        bstCaseCase2.search(numberCaseCase2_2 - 1);
                                    }

                                    // Print time in millis
                                    System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c222));


                                    // Calculate the used memory
                                    long memory2_222 = runtime2_222.totalMemory() - runtime2_222.freeMemory();
                                    System.out.println("Used memory is bytes: " + memory2_222);
                                    System.out.println("Used memory is megabytes: "
                                    + bytesToMegabytes(memory2_222));

                                    //bstCaseCase2.Visualisation();

                                }

                            break;

                            case(2):
                            
                                //transfer data
                                numberCaseCase2_2 = numberCaseCase2_2_copy;
                                
                                Runtime runtime2_222 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime2_222.gc();
    
                                // Time counting
                                long c222 = System.currentTimeMillis();

                                for(int i = 0; numberCaseCase2_2 > i; numberCaseCase2_2--)
                                {
                                    bstCaseCase2.search(numberCaseCase2_2 - 1);
                                }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c222));


                                // Calculate the used memory
                                long memory2_222 = runtime2_222.totalMemory() - runtime2_222.freeMemory();
                                System.out.println("Used memory is bytes: " + memory2_222);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory2_222));

                                //bstCaseCase2.Visualisation();
                   
                            break;

                        }

                    break;
            }
            
            
            
            
            
            
            break;

            case(3)://random

            int[] Array = new int[10000000];
		    int a1;
    	    try
		    {
    		    Scanner sc = new Scanner(new File("SetNum.txt"));
    		    for(int i = 0; i < 10000000; i++)
			    {
        		    a1=sc.nextInt();
				    Array[i] = a1;
    		    }
    	    }
		                
            catch(FileNotFoundException e)
		    {
        	    e.printStackTrace();        
    	    }

            System.out.println("SPALY - '1'\nAVL - '2'");
                int numberCaseCase3 = scanner.nextInt();
                
                switch(numberCaseCase3)
                {
                    case(1)://Splay

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase3_1 = scanner.nextInt();
                        SplayTree bstCaseCase3 = new SplayTree();

                        Runtime runtime3_1 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime3_1.gc();

                        // Time counting
                        long c1 = System.currentTimeMillis();

                        
    	
    		            for(int i = 0; i < numberCaseCase3_1; i++)
			            {
				            bstCaseCase3.insert(Array[i]);
    		            }
    	                
		                
                        

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c1));

                        // Calculate the used memory
                        long memory3_1 = runtime3_1.totalMemory() - runtime3_1.freeMemory();
                        System.out.println("Used memory is bytes: " + memory3_1);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory3_1));
                        
                        //bstCaseCase3.Visualisation();

                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation3_1 = scanner.nextInt();
                        
                        switch(nextOperation3_1)
                        {
                            case(1):

                            Runtime runtime3_11 = Runtime.getRuntime();
                            // Run the garbage collector
                            runtime3_11.gc();

                            // Time counting
                            long c11 = System.currentTimeMillis();

                            for(int i = 0; i < numberCaseCase3_1/2; i++)
			                {
				                bstCaseCase3.delete(Array[i]);
    		                }
                            
                            // Print time in millis
                            System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c11));

                            // Calculate the used memory
                            long memory3_11 = runtime3_11.totalMemory() - runtime3_11.freeMemory();
                            System.out.println("Used memory is bytes: " + memory3_11);
                            System.out.println("Used memory is megabytes: "
                            + bytesToMegabytes(memory3_11));

                            //bstCaseCase3.Visualisation();

                            System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                            int nextOperation2_1_1 = scanner.nextInt();

                            if(nextOperation2_1_1 == 1)
                            {

                                Runtime runtime3_111 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime3_111.gc();

                                // Time counting
                                long c111 = System.currentTimeMillis();

                                for(int i = 0; i < numberCaseCase3_1/2; i++)
			                    {
				                    bstCaseCase3.search(Array[i]);
    		                    }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));

                                // Calculate the used memory
                                long memory3_111 = runtime3_111.totalMemory() - runtime3_111.freeMemory();
                                System.out.println("Used memory is bytes: " + memory3_111);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory3_111));

                                //bstCaseCase3.Visualisation();

                            }

                            break;

                            case(2):
                              
                            Runtime runtime3_111 = Runtime.getRuntime();
                            // Run the garbage collector
                            runtime3_111.gc();

                            // Time counting
                            long c111 = System.currentTimeMillis();

                            for(int i = 0; i < numberCaseCase3_1/2; i++)
			                {
				                bstCaseCase3.search(Array[i]);
    		                }

                            // Print time in millis
                            System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c111));

                            // Calculate the used memory
                            long memory3_111 = runtime3_111.totalMemory() - runtime3_111.freeMemory();
                            System.out.println("Used memory is bytes: " + memory3_111);
                            System.out.println("Used memory is megabytes: "
                            + bytesToMegabytes(memory3_111));

                            //bstCaseCase3.Visualisation();
                   
                            break;

                        }

                    break;

                    case(2)://AVL

                        System.out.println("Enter amount of numbers( <= 10 000 000):");
                        int numberCaseCase3_2 = scanner.nextInt();
                        AVLTree bstCaseCase2 = new AVLTree();
                        
                        Runtime runtime3_2 = Runtime.getRuntime();
                        // Run the garbage collector
                        runtime3_2.gc();
                        
                        // Time counting
                        long c2 = System.currentTimeMillis();

                       
    		                
    		            for(int i = 0; i < numberCaseCase3_2; i++)
			            {
				            bstCaseCase2.insert(Array[i]);
    		            }
    	               

                        // Print time in millis
                        System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c2));

                        // Calculate the used memory
                        long memory3_2 = runtime3_2.totalMemory() - runtime3_2.freeMemory();
                        System.out.println("Used memory is bytes: " + memory3_2);
                        System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory3_2));
                        
                        //bstCaseCase2.Visualisation();

                        System.out.println("Next operation:\nDelete(50%) - 1\nSearch(50%) - 2");
                        int nextOperation3_2 = scanner.nextInt();
                        
                        switch(nextOperation3_2)
                        {
                            case(1):

                            Runtime runtime3_22 = Runtime.getRuntime();
                            // Run the garbage collector
                            runtime3_22.gc();
                        
                            // Time counting
                            long c22 = System.currentTimeMillis();


                            for(int i = 0; i < numberCaseCase3_2/2; i++)
			                {
				                bstCaseCase2.delete(Array[i]);
    		                }
                            
                            // Print time in millis
                            System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c22));

                            // Calculate the used memory
                            long memory3_22 = runtime3_22.totalMemory() - runtime3_22.freeMemory();
                            System.out.println("Used memory is bytes: " + memory3_22);
                            System.out.println("Used memory is megabytes: "
                            + bytesToMegabytes(memory3_22));

                            //bstCaseCase2.Visualisation();

                            System.out.println("Next operation:\nSearch(50%) - 1\nEnd - any");

                            int nextOperation2_1_1 = scanner.nextInt();

                            if(nextOperation2_1_1 == 1)
                            {

                                Runtime runtime3_222 = Runtime.getRuntime();
                                // Run the garbage collector
                                runtime3_222.gc();
                        
                                // Time counting
                                long c222 = System.currentTimeMillis();

                                for(int i = 0; i < numberCaseCase3_2/2; i++)
			                    {
				                    bstCaseCase2.search(Array[i]);
    		                    }

                                // Print time in millis
                                System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c222));

                                // Calculate the used memory
                                long memory3_222 = runtime3_222.totalMemory() - runtime3_222.freeMemory();
                                System.out.println("Used memory is bytes: " + memory3_222);
                                System.out.println("Used memory is megabytes: "
                                + bytesToMegabytes(memory3_222));

                                //bstCaseCase2.Visualisation();

                            }

                            break;

                            case(2):
                               
                            Runtime runtime3_222 = Runtime.getRuntime();
                            // Run the garbage collector
                            runtime3_222.gc();
                        
                            // Time counting
                            long c222 = System.currentTimeMillis();
                           
                            for(int i = 0; i < numberCaseCase3_2/2; i++)
			                {
				                bstCaseCase2.search(Array[i]);
    		                }

                            // Print time in millis
                            System.out.println("Used time in millis: " + (double) (System.currentTimeMillis() - c222));

                            // Calculate the used memory
                            long memory3_222 = runtime3_222.totalMemory() - runtime3_222.freeMemory();
                            System.out.println("Used memory is bytes: " + memory3_222);
                            System.out.println("Used memory is megabytes: "
                            + bytesToMegabytes(memory3_222));
                            
                            //bstCaseCase2.Visualisation();
                   
                            break;

                        }
                
                    break;
                }

            break;

           

        }

















	}

}
