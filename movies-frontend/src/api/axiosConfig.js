import axios from 'axios';

export default axios.create({
    baseURL: 'http://localhost:8080',
    // baseURL: "https://edfc-83-10-34-166.ngrok-free.app",
    headers: {'ngrok-skip-browser-warning': 'true'}
});