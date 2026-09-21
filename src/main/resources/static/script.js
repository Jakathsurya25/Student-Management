let editMode = false;


/* LOAD ALL STUDENTS */

async function loadStudents() {

    try {

        const response = await fetch("/students");

        const students = await response.json();

        displayStudents(students);

        // Clear search fields
        document.getElementById("rollSearch").value = "";
        document.getElementById("technologySearch").value = "";

    } catch (error) {

        console.error(error);

        alert("Unable to load students");

    }
}


/* DISPLAY STUDENTS */

function displayStudents(students) {

    const table =
        document.getElementById("studentTable");

    table.innerHTML = "";


    students.forEach(student => {

        const row =
            document.createElement("tr");


        row.innerHTML = `

            <td>${student.rno}</td>

            <td>${student.gender}</td>

            <td>${student.name}</td>

            <td>${student.technology}</td>

            <td>

                <button
                    class="edit-btn"
                    onclick='editStudent(${JSON.stringify(student)})'>

                    Edit

                </button>


                <button
                    class="delete-btn"
                    onclick="deleteStudent(${student.rno})">

                    Delete

                </button>

            </td>
        `;


        table.appendChild(row);

    });
}


/* OPEN ADD MODAL */

function openAddModal() {

    editMode = false;

    document.getElementById("modalTitle")
        .innerText = "Add Student";


    document.getElementById("rno")
        .value = "";

    document.getElementById("name")
        .value = "";

    document.getElementById("gender")
        .value = "";

    document.getElementById("technology")
        .value = "";


    document.getElementById("rno")
        .disabled = false;


    document.getElementById("studentModal")
        .style.display = "flex";
}


/* CLOSE MODAL */

function closeModal() {

    document.getElementById("studentModal")
        .style.display = "none";
}


/* SAVE / UPDATE STUDENT */

async function saveStudent() {

    const student = {

        rno: Number(
            document.getElementById("rno").value
        ),

        name:
        document.getElementById("name").value,

        gender:
        document.getElementById("gender").value,

        technology:
        document.getElementById("technology").value
    };


    if (
        !student.rno ||
        !student.name ||
        !student.gender ||
        !student.technology
    ) {

        alert("Please fill all fields");

        return;
    }


    try {

        const response = await fetch(
            "/students",
            {
                method: editMode ? "PUT" : "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body:
                    JSON.stringify(student)
            }
        );


        if (!response.ok) {

            const error =
                await response.json();

            alert(
                error.message ||
                "Something went wrong"
            );

            return;
        }


        alert(
            editMode
                ? "Student updated successfully"
                : "Student added successfully"
        );


        closeModal();

        loadStudents();


    } catch (error) {

        console.error(error);

        alert("Server error");

    }
}


/* EDIT STUDENT */

function editStudent(student) {

    editMode = true;


    document.getElementById("modalTitle")
        .innerText = "Edit Student";


    document.getElementById("rno")
        .value = student.rno;

    document.getElementById("name")
        .value = student.name;

    document.getElementById("gender")
        .value = student.gender;

    document.getElementById("technology")
        .value = student.technology;


    document.getElementById("rno")
        .disabled = true;


    document.getElementById("studentModal")
        .style.display = "flex";
}


/* DELETE STUDENT */

async function deleteStudent(rno) {

    const confirmDelete =
        confirm(
            "Are you sure you want to delete this student?"
        );


    if (!confirmDelete) {
        return;
    }


    try {

        const response =
            await fetch(
                `/students/${rno}`,
                {
                    method: "DELETE"
                }
            );


        if (!response.ok) {

            const error =
                await response.json();

            alert(error.message);

            return;
        }


        alert("Student deleted successfully");

        loadStudents();


    } catch (error) {

        console.error(error);

        alert("Server error");

    }
}


/* DELETE ALL */

async function deleteAllStudents() {

    const confirmDelete =
        confirm(
            "Are you sure you want to delete ALL students?"
        );


    if (!confirmDelete) {
        return;
    }


    try {

        const response =
            await fetch(
                "/students/clear",
                {
                    method: "DELETE"
                }
            );


        if (!response.ok) {

            alert("Unable to delete students");

            return;
        }


        alert("All students deleted");

        loadStudents();


    } catch (error) {

        console.error(error);

        alert("Server error");

    }
}


/* SEARCH BY ROLL NUMBER */

async function searchStudent() {

    const rno =
        document.getElementById("rollSearch").value;


    if (!rno) {

        alert("Enter roll number");

        return;
    }


    try {

        const response =
            await fetch(
                `/students/${rno}`
            );


        if (!response.ok) {

            const error =
                await response.json();

            alert(error.message);

            return;
        }


        const student =
            await response.json();


        displayStudents([student]);


    } catch (error) {

        console.error(error);

        alert("Server error");

    }
}


/* FILTER TECHNOLOGY */

async function filterTechnology() {

    const technology =
        document.getElementById(
            "technologySearch"
        ).value;


    if (!technology) {

        alert("Enter technology");

        return;
    }


    try {

        const response =
            await fetch(
                `/students/technology/${encodeURIComponent(technology)}`
            );


        const students =
            await response.json();


        displayStudents(students);


    } catch (error) {

        console.error(error);

        alert("Server error");

    }
}


/* LOAD WHEN PAGE OPENS */

window.onload = function () {

    loadStudents();

};