# WebexAttendanceManager

A little tool to convert the native webex attendance reports and custom person lists (name + email) into usable attendance reports with people separated into 3 groups (present, absent, unrecognized), organized into separate reports per groups.

# Usage

### 1. Set up your group/repeating event

Create a file in `./data/groups/` named `yourgroupname.csv`, for example `group1.csv`:

```
Test User 1,user1@mail.com
Test User 2,user2@mail.com
Test User 3,user3@mail.com
Test User 4,user4@mail.com
Test User 5,user5@mail.com
```


### 2. Add native webex reports

Create a folder by the same name as your group (group1 in this case) and place the report file downloaded from the webex interface.
Rename it to the date of the report, because in the final summarized report this file name will be used to identify the event on this date.
In my case, I placed it as `may4.csv` in `./data/webex/group1/`

This is what my report looks like now:
```
Event Name	Event Start Time	Event End Time	Name	Attendee Email	Join Time	Leave Time	Attendance Duration	Connection Type
Test Event	"=""2021-06-14 17:00:00"""	"=""2021-06-14 20:15:00"""	host	host@mail.com	"=""2021-06-14 16:58:50"""	"=""2021-06-14 20:22:49"""	204 mins	Desktop
Test Event	"=""2021-06-14 17:00:00"""	"=""2021-06-14 20:15:00"""	Test User 1	user1@mail.com	"=""2021-06-14 17:02:22"""	"=""2021-06-14 20:22:49"""	201 mins	Desktop
Test Event	"=""2021-06-14 17:00:00"""	"=""2021-06-14 20:15:00"""	Test User 2	user2@mail.com	"=""2021-06-14 17:02:26"""	"=""2021-06-14 20:22:36"""	201 mins	Desktop
Test Event	"=""2021-06-14 17:00:00"""	"=""2021-06-14 20:15:00"""	Test User 3	user3@mail.com	"=""2021-06-14 17:05:45"""	"=""2021-06-14 20:22:34"""	197 mins	Desktop
```


### 3. Run the code

Either build a jar or just use the IDE to run it. It will create the reports in `./data/attendance/`. In this case, it will created `group1.txt`:

```
Report: may4
Present: Test User 1,Test User 2,Test User 3
Absent: Test User 4,Test User 5
Unrecognized: host
```

If you put more reports in the same folder, they will be listed in the same file for the group, so you can just keep adding newer reports and it will appear after the rest. If you remove a report, re-running the app will remove it from the summarized report too, so be careful with that.
