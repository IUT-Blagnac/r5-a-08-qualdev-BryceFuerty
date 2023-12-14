Feature: An example

  Scenario Outline: The example
    Given The file is : "<Fichier>"
    When The subject is "<Sujet>"
    Then The file should cite the subject

    Examples:
          | Fichier     | Sujet |
          | fichier.pdf | Programmation |
          | Tom         | Jerry    |