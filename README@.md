https://stackoverflow.com/questions/38667621/jpa-hibernate-update-parent-column-value-before-inserting-child-column-value

ForEachOrdered() ----> Sequential
Sleep.sleep(2000) to sleep the currunt thread
map(Class::method) to call the class method

findFirst is always ordered

filter(Class::method) to call the class method to check values and return type is boolean

numbers.stream().parallel().reduce(0, (total, e) -> add(total, e)));//it means 0 or x used as a identity is for each row 
numbers.stream().reduce(0, (total, e) -> add(total, e)));

here 0 is identity value not the initial value like 0+x =0  0r 1 *1 *x = x 

#computaion Intensive operation

no. of Threds < No. of cores

#IO intensive operation

                                            # No. of cores
# No. of Threads  <=------------------------------------------------------------------------
                                           1 - blocking facter

	o < blocking facter <1 

	
	To find how many cores avialable in my machine 
	
	Runtime.getRuntime().avialableProcessores() /sysout
	
	ForJoinPool pool = ForJoinPool.commonPool();
	
	common pools show 1 less core bcz main thred is a part of common pool ,main thread participate in common pool
	
#At JVM Level to increase the common pool

	-Djava.util.cuncurrent.ForJoinPool.parallelism=100  // not to use directly ose at program level
(input stream){
	
	ForJoinPool pool = ForJoinPool.commonPool();
	
	pool.submit(() -> stream.forEach(e -> {});
	
	pool.shutDown();
	
	pool.awaitTermination(30, TimeUnit.Seconds);
	
	
Stream
   #	It does not execute a function on a collection of data 
   #   it insted executes a collection of functions on a piece of data.
  
FindFirst is Sequential
FindFirst with Parallel is Sequential
FindAny with Parallel is not Sequential

CompleteableFuture<Integer> cfuture = CompleteableFuture.supplyAsync(class, method);// run in common thread pool

ForJoinPool pool = ForJoinPool.commonPool(10);
---CompleteableFuture<Integer> cfuture = CompleteableFuture.supplyAsync(class, method, pool);
---cfuture.thenAccept(class::method);      //both run in same thread

---CompleteableFuture<Integer> cfuture = CompleteableFuture.supplyAsync(class, method, pool); //run in fork join pool
	Sleep.sleep(2000);
---cfuture.thenAccept(class::method);      //run in main thread

---CompleteableFuture<Integer> cfuture = CompleteableFuture.supplyAsync(class, method, pool); //run in fork join pool
	Sleep.sleep(2000);
---cfuture.thenAcceptAsync(class::method, pool);      //run in  fork join pool thread

ForJoinPool pool1 = ForJoinPool.commonPool(5);
---CompleteableFuture<Integer> cfuture = CompleteableFuture.supplyAsync(class, method, pool); //run in fork join pool
	Sleep.sleep(2000);
---cfuture.thenAcceptAsync(class::method, pool);      //run in  fork join pool1 thread


thenApply(); is like map operation.

public class sample {

	public static int generate(int value){
	Sleep.sleep(2000)
	return 2;
	}
	
	public static void printIt(int value){
	System.out.println(value);
	}
	
	public static int processError(Throwable th){
	System.out.println("ERROR: " +th.getMessage());
	throw new RunTimeException("I hate this");
	}
	
	public static void main(String[] args){
	
	CompletebleFuture< integer> future = CompletebleFuture.supplyAsync(Sample::generate)
			.exceptionally(Sample::processError)
			.orTimeoutException(2, TimeUnit.SECONDS)
			.thenApply(data -> data * 2)
			.exceptionally(Sample::processError)
			.thenAccept(data -> printIt(data));
			
			future.completedOnTimeOut(77, 2, TimeUnit.SECONDS);
	return 2;
	}
	
	}
	
	CompletebleFuture< integer> goog = CompletebleFuture.supplyAsync(() -> getStockPrice("GOOG", 1));
	CompletebleFuture< integer> amz = CompletebleFuture.supplyAsync(() -> getStockPrice("GOOG", 1));
	
	goog.thenCombine(amz Integer::sum) //equally  goog.thenCombine(amz (g,a) -> g+a) 
	     .thenAccept(values -> System.out.println(values))
