#!/bin/bash

# Define the service URL
SERVICE_URL="http://10.43.21.67"  # Replace with your service URL

echo "Testing session affinity for $SERVICE_URL"
echo "----------------------------------------"

# Run multiple requests
for i in {1..10}; do
    POD_IP=$(curl -s $SERVICE_URL | grep "Response from pod:" | awk '{print $4}')
    
    # Print the response
    if [ -n "$POD_IP" ]; then
        echo "Request $i -> Response from Pod: $POD_IP"
    else
        echo "Request $i -> No valid response"
    fi
done

echo "----------------------------------------"
