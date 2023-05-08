# synchronization

## Using multi-threading in Java, write a program that demonstrates how multiple threads can share the  same memory:<br>
* Create a program that creates N number of threads.<br>
* Have a shared memory called “shared_mem” of type “int”.<br>
* Each process then performs the following steps:<br>
    * Sleeps for (TID%10) nanoseconds:<br>
       * Use ”getId()” to get the process ID.<br>
       * Use ” Thread.sleep()” to sleep for a number of nanoseconds<br>
       * Print the delay value before going to sleep, along with the thread ID; i.e.:<br>
              * “I am thread #xx about to go to sleep for ## nanoseconds” <br>
    * Increments the shared int:<br>
* Print a log message with this action, i.e.:
      * “I am thread #xx; about to increment the counter, old value was %d.”<br>
      * “I am thread #xx; finished incrementing the counter, new value is %d.”<br>
* Each thread repeats those steps for N times and finishes its job.<br>
* The parent thread which started everything waits for all threads to finish:<br>
    * Check “Thread.join()” 
* Finally, the parent thread displays the final counter value, AND the expected counter value:<br>
    * Expected value is simply N^2.<br> 
    * Final value is usually not correct: we will fix this in the next assignment using thread synchronization.<br>
* N is the three right most digits of your student ID + 500 in this assignment.<br>
    * i.e. if you ID is 11834535 then N = 535+500 = 1035 <br>

synchronized method.
