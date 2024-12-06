#ToDoList 


import os

# Function to display the tasks
def display(tasks):
    if not tasks:
        print("No tasks to display.")
    else:
        print("Your To-Do List:")
        for index, task in enumerate(tasks, 1):
            print(f"{index}. {task}")

# Function to add a task
def add(tasks):
    task = input("Enter the task to add: ")
    tasks.append(task)
    print(f"Task '{task}' added to your list.")

# Function to remove a task
def remove(tasks):
    try:
        task_number = int(input("Enter the task number to remove: "))
        removed = tasks.pop(task_number - 1)
        print(f"Task '{removed}' removed from your list.")
    except (ValueError, IndexError):
        print("Invalid task number.")

# Function to mark a task as complete
def mark_complete(tasks):
    try:
        task_number = int(input("Enter the task number to complete: "))
        tasks[task_number - 1] += " (Completed)"
        print(f"Task '{tasks[task_number - 1]}' marked as complete.")
    except (ValueError, IndexError):
        print("Invalid task number.")

# Function to save tasks to a file
def save(tasks, filename="tasks.txt"):
    with open(filename, "w") as file:
        for task in tasks:
            file.write(task + "\n")
    print("Tasks saved successfully.")

# Function to load tasks from a file
def load(filename="tasks.txt"):
    if os.path.exists(filename):
        with open(filename, "r") as file:
            return [task.strip() for task in file.readlines()]
    return []

def main():
    tasks = load()  # Load tasks from file if exists
    while True:
        print("\nTo-Do List Application")
        print("1. View Tasks")
        print("2. Add Task")
        print("3. Remove Task")
        print("4. Mark Task as Complete")
        print("5. Save and Exit")
        choice = input("Select an option: ")

        if choice == "1":
            display(tasks)
        elif choice == "2":
            add(tasks)
        elif choice == "3":
            remove(tasks)
        elif choice == "4":
            mark_complete(tasks)
        elif choice == "5":
            save(tasks)
            print("Exiting the application.")
            break
        else:
            print("Invalid option, please try again.")

if __name__ == "__main__":
    main()
