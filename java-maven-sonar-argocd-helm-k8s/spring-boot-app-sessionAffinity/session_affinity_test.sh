#!/bin/bash

# Define the service URL
SERVICE_URL="http://10.43.21.67"  # Replace with your service URL

echo "Testing session affinity for $SERVICE_URL"
echo "----------------------------------------"

# Run multiple requests
for i in {1..10}; do
    RESPONSE=$(curl -s -w "\nNode IP: %{remote_ip}" $SERVICE_URL)

    # Extract a unique identifier from the response (hostname or node IP)
    POD_IDENTIFIER=$(echo "$RESPONSE" | grep -oP '(?<=<h1>).*(?=</h1>)')
    NODE_IP=$(echo "$RESPONSE" | grep -oP '(?<=Node IP: ).*')

    # Print the response
    if [ -n "$POD_IDENTIFIER" ]; then
        echo "Request $i -> Response Identifier: $POD_IDENTIFIER | Node: $NODE_IP"
    else
        echo "Request $i -> No valid response"
    fi
done

echo "----------------------------------------"
