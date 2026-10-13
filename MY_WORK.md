# My Assignment Work Log & Reflection

## Student Information
- *Name:* turki alanazi
- *Student ID:* 444052409
- *Repository:* https://github.com/444052409-beep/OS-Assignment1-TURKI-ALANAZI

---

## 1. Development Log
- *2026-10-10:* Created the repository fork from the starter template and updated student ID to 444052409 in SchedulerSimulation.java.
- *2026-10-11:* Implemented process priority generation (1-10) and ensured ready queue display formatting without altering FIFO order.
- *2026-10-11:* Added the static context switch counter to track and increment whenever a new process starts execution.
- *2026-10-12:* Integrated System.currentTimeMillis() tracking to compute waiting times and turnaround times accurately.
- *2026-10-12:* Formatted and tested the final summary table output, verified the commit history, and recorded the demonstration video.

---

## 2. Reflection
Working on this CPU scheduling assignment provided a comprehensive hands-on experience regarding how operating systems manage processes using the Round-Robin algorithm. Throughout the development process, understanding how time quanta affect process execution cycles bridged the gap between theoretical operating systems concepts and practical Java programming. Implementing features like the context switch counter and waiting time tracking highlighted the performance trade-offs inherent in scheduling decisions. Furthermore, managing the project via Git and structuring separate commits for each feature reinforced professional software development habits. Overall, this assignment deepened my appreciation for concurrency control, thread management, and the underlying mechanics of modern operating systems.

---

## 3. Technical Answers
1. *Thread vs Process:* A process is an independent execution unit with its own memory space and system resources, whereas threads exist within a process and share its memory space, making inter-thread communication faster. In my code, multiple threads represent individual simulated processes running concurrently under the scheduler's control.
2. *Ready Queue Behavior:* The ready queue maintains processes waiting for CPU allocation using a First-In, First-Out (FIFO) queue structure combined with a fixed time quantum. Although process priorities were added for display purposes, the scheduling queue strictly adheres to the Round-Robin order to ensure fair CPU sharing.
3. *Thread Lifecycle:* A thread transitions through several states including New, Runnable, Running, Waiting/Blocked, and Terminated. In this simulation, threads are instantiated, placed in the ready queue, scheduled to run for a specific quantum, and finally terminated upon completion of their burst time.
4. *Real-World Applications:* Round-Robin scheduling is widely utilized in time-sharing operating systems like Linux and Windows for interactive user applications to ensure responsive multitasking. By distributing short time slices to active processes, the system prevents any single task from monopolizing the CPU resources.

---

## 4. Demonstration Video Link
[ضع رابط الفيديو الخاص بك هنا هنا]
