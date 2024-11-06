let chartInstance;
function resetChart() {
    if (chartInstance) {
        chartInstance.destroy();
    }
}

async function fetchTimeSpentData(studentId) {
    const response = await fetch(`/api/v1/students/${studentId}/timeSpent`);
    const data = await response.json();

    const moduleCodes = data.map(item => item.moduleCode);
    const timeSpentValues = data.map(item => item.timeSpent);

    resetChart();
    chartInstance = new Chart(document.getElementById('chartCanvas'), {
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

async function fetchResultsDistribution(studentId) {
    const response = await fetch(`/api/v1/students/${studentId}/resultsDistribution`);
    const data = await response.json();

    const results = Object.keys(data);
    const percentages = Object.values(data);

    resetChart();
    chartInstance = new Chart(document.getElementById('chartCanvas'), {
        type: 'pie',
        data: {
            labels: results,
            datasets: [{
                label: 'Results Distribution',
                data: percentages,
                backgroundColor: [
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)'
                ],
                borderColor: [
                    'rgba(75, 192, 192, 1)',
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Results Distribution'
                },
                datalabels: {
                    color: '#000',
                    formatter: (value, context) => {
                        const label = context.chart.data.labels[context.dataIndex];
                        return `${label}: ${value}%`;
                    },
                    font: {
                        weight: 'bold'
                    },
                    anchor: 'center',
                    align: 'center'
                }
            }
        },
        plugins: [ChartDataLabels]
    });
}
