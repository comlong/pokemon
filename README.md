
### Objective

Your assignment is to create a Pokémon API from CSV and JSON data using Java. You are free to choose any library and/or framework.

### Brief

Professor Oak is in trouble! A wild Blastoise wreaked havoc in the server room and destroyed every single machine. There are no backups - everything is lost! Professor Oak quickly scribbles down all the Pokémon from memory and hands them to you on a piece of paper. (/Data/pokemon.csv). He also unearths some old JSON data dump on a USB stick. (Data/pokemon.json).
Your task is to restore the Pokémon Database using both JSON, CSV files and create Pokémon API interface(es) so that they’re never lost again.

### Tasks

- Implement assignment using:
    -   Language: **Java**
    -   Framework: **any framework**
- Create a Pokémon Model that includes all fields outlined in `pokemon.csv / pokemon.json`
- Parse and load the files(JSON and CSV) to create entries for each record based on the following initial conditions:
    - Exclude Legendary Pokémon
    - Exclude Pokémon of Type: Ghost
    - For Pokémon of Type: Steel, double their HP
    - For Pokémon of Type: Fire, lower their Attack by 10%
    - For Pokémon of Type: Bug & Flying, increase their Attack Speed by 10%
    - For Pokémon that start with the letter **G**, add +5 Defense for every letter in their name (excluding **G**)
- Implement API interface(s) which can be used for,
    - Listing Pokémon(s).
    - Searching, filtering and paginating Pokémon(s). Following are some criterias for search, filter and pagination.
        -   Search: By **Name**
        -   Filter: Using **HP, Attack & Defense**. (Example : Filter should be capable of returning Pokémon(s) with `HP >= 10 and Attack <= 100 and Attack >= 50 and Defense >= 45`)
        -   Pagination: Navigate by different page numbers (Optionally : by different page sizes)

### Evaluation Criteria

- **Java** best practices
- Show us your work through your commit history
- We're looking for you to produce working code, with enough room to demonstrate how to structure components in a small program
- Completeness: did you complete the features?
- Correctness: does the functionality act in sensible, thought-out ways?
- Maintainability: is it written in a clean, maintainable way?
- Testing: is the system adequately tested?
- Documentation: We will need to build and run your application

### CodeSubmit

Please organize, design, test and document your code as if it were going into production - then push your changes to the master branch. After you have pushed your code, you may submit the assignment on the assignment page. If you would like to explain more about your work, you can make a short video and upload to CodeSubmit at the end of the submission.

All the best and happy coding,

The Axual Team
