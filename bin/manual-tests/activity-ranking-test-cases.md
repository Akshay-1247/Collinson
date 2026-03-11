Test Case ID: TC_001
Scenario: Autocomplete suggestions appear while typing a city

Preconditions
Mobile application installed
Device connected to the internet
User is on the city search screen

| Step | Action                        | Expected Result                 |
| ---- | ----------------------------- | ------------------------------- |
| 1    | Launch the mobile application | Home screen loads               |
| 2    | Tap the city search field     | Keyboard appears                |
| 3    | Type "Lon"                    | Autocomplete suggestions appear |
| 4    | Observe suggestion list       | Suggestions include "London"    |


Test Case ID: TC_002
Scenario: Suggestions update dynamically while typing

Preconditions
App launched
User on search screen

| Step | Action                | Expected Result                         |
| ---- | --------------------- | --------------------------------------- |
| 1    | Tap search field      | Cursor active                           |
| 2    | Type "Pa"             | Suggestions related to "Pa" appear      |
| 3    | Continue typing "Par" | Suggestions update dynamically          |
| 4    | Observe suggestions   | Suggestions relevant to "Par" displayed |


Test Case ID: TC_003
Scenario: Selecting a city suggestion triggers ranking request

Preconditions
Autocomplete suggestions visible

| Step | Action                  | Expected Result                       |
| ---- | ----------------------- | ------------------------------------- |
| 1    | Type "Lon"              | Suggestions appear                    |
| 2    | Tap "London" suggestion | City selected                         |
| 3    | Wait for results        | Activity ranking results screen loads |


Test Case ID: TC_004
Scenario: Activity ranking for next 7 days displayed

Preconditions
Valid city selected

| Step | Action                 | Expected Result                    |
| ---- | ---------------------- | ---------------------------------- |
| 1    | Select city suggestion | Results screen opens               |
| 2    | View ranking results   | Activity rankings displayed        |
| 3    | Count results          | At least 7 days of results visible |


Test Case ID: TC_005
Scenario: Each result contains required information

Preconditions
Activity ranking results displayed

| Step | Action                    | Expected Result                               |
| ---- | ------------------------- | --------------------------------------------- |
| 1    | View activity result card | Card visible                                  |
| 2    | Check fields              | Date displayed                                |
| 3    | Check activity name       | Activity name visible                         |
| 4    | Check rank                | Rank displayed between 1–10                   |
| 5    | Check reasoning           | Reason displayed (e.g., "Clear skies & 22°C") |


Test Case ID: TC_006
Scenario: Only supported activities appear

Preconditions
Activity ranking results loaded

| Step | Action                  | Expected Result                 |
| ---- | ----------------------- | ------------------------------- |
| 1    | View list of activities | Activity cards visible          |
| 2    | Inspect activity names  | Activities should only include: |
|      |                         | Skiing                          |
|      |                         | Surfing                         |
|      |                         | Outdoor Sightseeing             |
|      |                         | Indoor Sightseeing              |


Test Case ID: TC_007
Scenario: No autocomplete suggestions for invalid input

Preconditions
User on search screen

| Step | Action           | Expected Result                      |
| ---- | ---------------- | ------------------------------------ |
| 1    | Tap search field | Keyboard appears                     |
| 2    | Type "zzzzzz"    | No suggestions appear                |
| 3    | Observe UI       | Message "No results found" displayed |


Test Case ID: TC_008
Scenario: Error displayed when weather service fails

Preconditions
Weather API unavailable (simulate by disabling API or network)

| Step | Action                 | Expected Result         |
| ---- | ---------------------- | ----------------------- |
| 1    | Enter valid city       | Suggestions appear      |
| 2    | Select city suggestion | Request sent            |
| 3    | API fails              | Error message displayed |
| 4    | Check UI               | Retry option visible    |


Test Case ID: TC_009
Scenario: Loading indicator during API request

Preconditions
Slow network connection

| Step | Action            | Expected Result                 |
| ---- | ----------------- | ------------------------------- |
| 1    | Enter valid city  | Suggestions appear              |
| 2    | Select suggestion | Request initiated               |
| 3    | Observe screen    | Loading indicator displayed     |
| 4    | Wait for response | Results displayed after loading |


Test Case ID: TC_010
Scenario: No suggestions when search field is empty

Preconditions
App open on search screen

| Step | Action            | Expected Result          |
| ---- | ----------------- | ------------------------ |
| 1    | Tap search field  | Cursor appears           |
| 2    | Leave field empty | No suggestions displayed |

