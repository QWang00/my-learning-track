
async function fetchTimeSpentData(studentId) {
    const response = await fetch(`/api/v1/students/${studentId}/timeSpent`);
    const data = await response.json();

    const moduleCodes = data.map(item => item.moduleCode);
    const timeSpentValues = data.map(item => item.timeSpent);

    new Chart(document.getElementById('timeSpentChart'), {
        type: 'bar',
        data: {
            labels: moduleCodes,
            datasets: [{
                label: 'Time Spent (minutes)',
                data: timeSpentValues,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Time Spent (minutes)'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: 'Module Code'
                    }
                }
            }
        }
    });
}
